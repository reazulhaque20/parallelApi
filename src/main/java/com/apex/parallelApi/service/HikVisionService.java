//package com.apex.parallelApi.service;
//
//import com.apex.parallelApi.model.AcsEvent;
//import com.apex.parallelApi.model.InfoList;
//import com.apex.parallelApi.model.MachineDetails;
//import com.apex.parallelApi.model.UserMachineLog;
//import com.apex.parallelApi.repository.MachineDetailsRepo;
//import com.apex.parallelApi.repository.UserMachineLogRepo;
//import com.burgstaller.okhttp.digest.CachingAuthenticator;
//import com.burgstaller.okhttp.digest.Credentials;
//import com.burgstaller.okhttp.digest.DigestAuthenticator;
//import com.google.gson.Gson;
//import lombok.RequiredArgsConstructor;
//import com.burgstaller.okhttp.*;
//import okhttp3.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.boot.configurationprocessor.json.JSONArray;
//import org.springframework.boot.configurationprocessor.json.JSONException;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ConcurrentHashMap;
//@Component
//@Service
//@RequiredArgsConstructor
//public class HikVisionService {
//
//    private final UserMachineLogRepo userMachineLogRepo;
//    private final MachineDetailsRepo machineDetailsRepo;
//    private static final Logger log = LogManager.getLogger(HikVisionService.class);
//
//    @Async
//    public CompletableFuture<AcsEvent> getHikVisionLogData() {
//        List<MachineDetails> machineDetailsList = new ArrayList<>();
//        AcsEvent acsEvent = new AcsEvent();
//        UserMachineLog userMachineLog = new UserMachineLog();
//
//        List<UserMachineLog> userMachineLogList = new ArrayList<>();
//        try {
//            machineDetailsList = machineDetailsRepo.findAllByStatus("ACTIVE");
//        } catch (Exception exception) {
//            log.error("Error while getting machine list");
//        }
//        try{
//            if (machineDetailsList.size() > 0) {
//                for (MachineDetails machine : machineDetailsList) {
//                    JSONObject jsonObject = getData(machine, 0);
//                    acsEvent = new Gson().fromJson(jsonObject.toString(), AcsEvent.class);
//                    for (InfoList infoList : acsEvent.getInfoList()) {
//                        userMachineLog.setLogDate(infoList.getTime());
//                        userMachineLog.setMcType("HIKVISION");
//                        userMachineLog.setThreadId(Thread.currentThread().getId());
//                        userMachineLog.setUserId(Long.parseLong(infoList.getEmployeeNoString()));
//                        userMachineLog.setDeviceIdentifier(machine.getMachineId());
//                        userMachineLog.setLocation(machine.getFloorLocation());
//                        userMachineLog.setStatus("A");
//                        userMachineLogList.add(userMachineLog);
//                        userMachineLog = new UserMachineLog();
//                    }
//                    String moreData = acsEvent.getResponseStatusStrg();
//                    if (moreData.equalsIgnoreCase("MORE")) {
//                        for (int i = 31; moreData.equalsIgnoreCase("MORE"); i += 30) {
//                            JSONObject jsonObjectMore = getData(machine, i);
//                            acsEvent = new Gson().fromJson(jsonObjectMore.toString(), AcsEvent.class);
//                            for (InfoList infoList : acsEvent.getInfoList()) {
//                                userMachineLog.setLogDate(infoList.getTime());
//                                userMachineLog.setMcType("HIKVISION");
//                                userMachineLog.setThreadId(Thread.currentThread().getId());
//                                userMachineLog.setUserId(Long.parseLong(infoList.getEmployeeNoString()));
//                                userMachineLog.setDeviceIdentifier(machine.getMachineId());
//                                userMachineLog.setLocation(machine.getFloorLocation());
//                                userMachineLog.setStatus("A");
//                                userMachineLogList.add(userMachineLog);
//                                userMachineLog = new UserMachineLog();
//                                try {
//                                    userMachineLogRepo.save(userMachineLog);
//                                }catch(Exception exception){
//                                    log.error("Error While Insert into DB: "+exception);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//    }catch(Exception e){
//        log.error("Error While Parsing Data" + e);
//    }
//
//        return CompletableFuture.completedFuture(acsEvent);
//    }
//
//    public JSONObject getData(MachineDetails machine, int searchIndex){
//        log.info("Collecting Log Data From Device......");
//        String url = "http://"+machine.getMachineIp()+"/ISAPI/AccessControl/AcsEvent?format=json";
//        DigestAuthenticator authenticator = new DigestAuthenticator(new Credentials("admin", "Hik12345"));
//        Map<String, CachingAuthenticator> authCache = new ConcurrentHashMap<>();
//        OkHttpClient client = new OkHttpClient.Builder()
//                .authenticator(new CachingAuthenticatorDecorator(authenticator, authCache))
//                .addInterceptor(new AuthenticationCacheInterceptor(authCache)).build();
//        MediaType mediaType = MediaType.parse("application/json");
//
//        String today = java.time.LocalDate.now().toString();
//
//        RequestBody body = RequestBody.create(mediaType, "{\r\n   \"AcsEventCond\":{\r\n      \"searchID\":\"3242s34\",\r\n      \"searchResultPosition\":"+searchIndex+",\r\n      \"numOfMatches\": 300,\r\n      \"maxResults\":600,\r\n      \"major\":5,\r\n      \"minor\":75,\r\n      \"startTime\":\""+today+"T00:00:00+07:00\",\r\n      \"endTime\":\""+today+"T23:59:47+07:00\"\r\n   }\r\n}");
//        Request request = new Request.Builder().url(url).post(body).build();
//
//        new JSONObject();
//        JSONObject infoListObject;
//        log.info("Collecting Data From: " + machine.getMachineIp());
//        try {
//            Response response = client.newCall(request).execute();
//            String result = response.body().string();
//            JSONObject mainObject = new JSONObject(result);
//            infoListObject = mainObject.getJSONObject("AcsEvent");
//            JSONArray jsonArray = infoListObject.getJSONArray("InfoList");
//            log.info("Data Received From Machine: " + machine.getMachineIp());
//            log.info("Data Is: "+jsonArray.toString());
//            return infoListObject;
//        } catch (IOException e) {
//            log.error("ERROR: "+e);
//            return null;
//        } catch (JSONException e) {
//            log.error("JSONException Error."+e);
//            return null;
//        }catch (NullPointerException nullPointerException){
//            log.error("Null Pointer Exception: "+nullPointerException);
//            return null;
//        }
//
//
//    }
//}
