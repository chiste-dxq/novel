package com.chiste.novel.controller;

import com.chiste.novel.common.rabbitmq.constant.RabbitMQConstant;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

/*
 * @Author: daixq
 * @Date: 2021/5/28 9:20
 * @Description:
 **/
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile){
        try {
            multipartFileToFile(uploadFile);
            System.out.println("转换完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/test")
    public void test(){
        System.out.println("DeadLetterSender 发送时间:" + LocalDateTime.now().toString() + " msg内容：" + "测试延时消费");
        rabbitTemplate.convertAndSend(RabbitMQConstant.DELAY_MSG_EXCHANGE,RabbitMQConstant.DELAY_MSG_KEY, "测试延时消费", message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setDelay(3000);
            return message;
        });
    }

    public File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File("D://"+file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }
}
