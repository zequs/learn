package com.zequs.learn.se.file.input;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * 音乐播放输入流,是用java来播放音乐
 * 据说做播放器是用ffmpeg库（个人眼光）
 */
public class AudioInputStreamDemo {

    public static void main(String[] args) throws Exception{
//        String filename = "E:\\music\\smlt.mp3";
        //必须是mav文件。
        String music = "E:\\music\\林俊杰 - 可惜没如果.wav";
        demo(music);
//        playWavMusic(music);
    }

    public static void demo(String music) throws Exception{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(music));

        AudioFormat audioFormat = audioInputStream.getFormat();
        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
                audioFormat, AudioSystem.NOT_SPECIFIED);
        SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem
                .getLine(dataLineInfo);
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();
        int count;
        byte tempBuffer[] = new byte[1024];
        int i = 0;
        while ((count = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
            if (count > 0) {
                sourceDataLine.write(tempBuffer, 0, count);
                i++;
            }
        }
        System.out.println(11);
        // 清空数据缓冲,并关闭输入
        sourceDataLine.drain();
        sourceDataLine.close();
    }

    /**
     * 只能播放mav格式的文件
     * @param fileName
     * @throws Exception
     */
    public static void playWavMusic(String fileName) throws Exception{
        FileInputStream fileau=new FileInputStream(fileName);
        AudioStream as=new AudioStream(fileau);
        AudioPlayer.player.start(as);
    }
}
