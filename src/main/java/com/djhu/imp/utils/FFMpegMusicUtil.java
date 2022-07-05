package com.djhu.imp.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class FFMpegMusicUtil {


//  private static final Logger logger = Logger.getLogger(FFMpegMusicUtil.class);
    private static final String HOME_PATH;//获得程序当前路径
    private static String FFMPEG_PATH;//ffMpeg解压的bin地址
    private static String TMP_PATH;//转为音频后 存放的地址
    private static String MUSIC_ADDRESS;



//    @Autowired
//    QiniuUtil qiniuUtil;

   /* @Value("${ffmpeg_path}")//获取配置文件的参数
    public void setFFMPEG_PATH(String fFMPEG_PATH) {
        FFMPEG_PATH = fFMPEG_PATH;
    }
    @Value("${tmp_path}")
    public void setTMP_PATH(String tMP_PATH) {
        TMP_PATH = tMP_PATH;
    }
    @Value("${music_address}")
    public void setMUSIC_ADDRESS(String mUSIC_ADDRESS) {
        MUSIC_ADDRESS = mUSIC_ADDRESS;
    }*/


    static {
        HOME_PATH = System.getProperty("user.home");
        log.info("static home path : " + HOME_PATH);
    }

    /**
     * 视频转音频 返回上传的音频地址
     * @param videoUrl 视频地址
     */
    public  String videoToAudio(String videoUrl,String videoName){
       String  FFMPEG_PATH="D:\\ffmpeg-20190815-3aeb681-win64-static\\bin\\";
       String   TMP_PATH = "C:\\Users\\Administrator\\Desktop\\ppt";
       String HOME_PATH = "";
        String musicUrl = "";
        try {
            String aacFile = HOME_PATH + TMP_PATH + videoName + ".aac";
            String command = FFMPEG_PATH + "ffmpeg -i "+ videoUrl + " -y -f ac3 -vn "+ aacFile;
            log.info("video to audio command : " + command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            //上传七牛云
          /*  Response res = qiniuUtil.uploadMusic(aacFile,videoName+".aac");
            if(res != null && res.isOK()) {
                //上传的地址
                musicUrl =  MUSIC_ADDRESS + videoName+".aac";
                // 上传成功后删除本地音频文件
                File file = new File(aacFile);
                file.delete();
            }else {
                logger.error("音频文件上传失败,音频路径：" + aacFile);
            }*/
        } catch (Exception e) {
//            logger.error("音频提取失败，视频地址："+videoUrl, e);
        }
        return musicUrl;
    }


    public static void main(String[] args) {
        String  FFMPEG_PATH="D:\\ffmpeg-20190815-3aeb681-win64-static\\bin\\";
        String   TMP_PATH = "C:\\Users\\Administrator\\Desktop\\ppt\\";
        String HOME_PATH = "";
        String musicUrl = "";
        String videoName = "15b6530-17467aa2f35";
        String videoUrl = "C:\\Users\\Administrator\\Desktop\\ppt\\15b6530-17467aa2f35.mp4";
        try {
//            ffmpeg -i file.mp4 -b:a 128k file.mp3   //mp3与原视频时长相等
//            ffmpeg -i foo.mp4 foobar.mp3
            String aacFile = HOME_PATH + TMP_PATH + videoName + ".mp3";
            String command = FFMPEG_PATH + "ffmpeg -i "+ videoUrl + "  "+ aacFile;
            log.info("video to audio command : " + command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor(2, TimeUnit.SECONDS);
            //上传七牛云
          /*  Response res = qiniuUtil.uploadMusic(aacFile,videoName+".aac");
            if(res != null && res.isOK()) {
                //上传的地址
                musicUrl =  MUSIC_ADDRESS + videoName+".aac";
                // 上传成功后删除本地音频文件
                File file = new File(aacFile);
                file.delete();
            }else {
                logger.error("音频文件上传失败,音频路径：" + aacFile);
            }*/
        } catch (Exception e) {
//            logger.error("音频提取失败，视频地址："+videoUrl, e);
        }
        System.out.println(musicUrl);
//        return musicUrl;
    }
}