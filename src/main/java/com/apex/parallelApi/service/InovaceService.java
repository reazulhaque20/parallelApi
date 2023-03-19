package com.apex.parallelApi.service;

import com.apex.parallelApi.model.LogData;
import com.apex.parallelApi.model.RootData;
import com.apex.parallelApi.model.UserMachineLog;
import com.apex.parallelApi.repository.UserMachineLogRepo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;
@Component
@Service
@RequiredArgsConstructor
public class InovaceService {
    private final UserMachineLogRepo userMachineLogRepo;
    private static final Logger log = LogManager.getLogger(InovaceService.class);

    @Async
    public CompletableFuture<RootData> getDeviceLog() {
        RestTemplate restTemplate = new RestTemplate();
        String start = java.time.LocalDate.now().toString();//"2022-09-12";
        String end = java.time.LocalDate.now().toString();//"2022-09-13";
        String url = "http://192.168.17.50/api/v1/logs/?start="+ start +" 00:00:58&end="+ end +" 23:59:00&api_token=e9b4-bb9c-7bab-1be8-bc33-0dbd-15a3-6cb4-2b6f-c6df-34c7-03fb-d5bb-3271-4ae0-2f5b&order_direction=desc";
        String responseStr = null;
        RootData rootData = new RootData();
        try{
            rootData = restTemplate.getForObject(url, rootData.getClass());
            log.info("Response: " + rootData);
        }catch(Exception exception){
            log.error("Exception: " + exception);
        }
        UserMachineLog userMachineLog = new UserMachineLog();
        List<UserMachineLog> userMachineLogList = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        for(LogData logData : rootData.getData()){
            userMachineLog.setId(0L);
            userMachineLog.setUserId(Long.parseLong(logData.getPerson_identifier()));
            userMachineLog.setLogDate(logData.getLogged_time());
            userMachineLog.setMcType("INOVACE");
            userMachineLog.setThreadId(Thread.currentThread().getId());
            userMachineLog.setDeviceIdentifier(Long.parseLong(logData.getDevice_identifier()));
            userMachineLog.setLocation(logData.getLocation());
            userMachineLog.setStatus("A");
            userMachineLogList.add(userMachineLog);
            userMachineLog = new UserMachineLog();
            try {
                userMachineLogRepo.save(userMachineLog);
            }catch(Exception exception){
                log.error("Error While Insert into DB: "+exception);
            }
        }
//        userMachineLogRepo.saveAll(userMachineLogList);
        return CompletableFuture.completedFuture(rootData);
    }

    private String addOneDay() throws ParseException {
        String dt = "2022-09-12";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, 1);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        return dt;
    }
}
