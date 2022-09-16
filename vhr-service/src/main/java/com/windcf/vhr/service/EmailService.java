package com.windcf.vhr.service;

/**
 * @author chunf
 * @time 2022-09-16 10:19
 * @package com.windcf.vhr.service
 * @description eamil service
 */
public interface EmailService {
    /**
     * send simple text email
     *
     * @param to      send to
     * @param subject subject
     * @param content mail content
     */
    void sendSimpleMail(String to, String subject, String content);
}
