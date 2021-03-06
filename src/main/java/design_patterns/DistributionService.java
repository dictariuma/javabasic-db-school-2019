package design_patterns;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

/**
 * @author Evgeny Borisov
 */
@Service
public class DistributionService {
    @Autowired
    private Map<String, MailGenerator> map;

    @Autowired
    private MailDao mailDao;


    @Scheduled(fixedDelay = 500)
    public void sendMail() {
        int mailCode = mailDao.getMailCode();
        MailGenerator mailGenerator = map.get(String.valueOf(mailCode));
        if (mailGenerator == null) {
            System.out.println(mailCode + " not supported yet");
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }
        String html = mailGenerator.generateMail();
        send(html);
    }



    private void send(String html) {
        System.out.println("html was sent: " + html);
    }
}



