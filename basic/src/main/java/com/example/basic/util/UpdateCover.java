package com.example.basic.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Bashan
 * FFMPEG homepage http://ffmpeg.org/about.html
 * By Google Get first and last thumb of a video using Java and FFMpeg
 * From http://www.codereye.com/2010/05/get-first-and-last-thumb-of-video-using.html
 */

public class UpdateCover
{
    protected String ffmpegApp;

    public UpdateCover(String ffmpegApp)
    {
        this.ffmpegApp = ffmpegApp;
    }

    @SuppressWarnings("unused")
    /****
     * 获取指定时间内的图片
     * @param videoFilename:视频路径
     * @param thumbFilename:图片保存路径
     * @throws IOException
     * @throws InterruptedException
     */
    public void getThumb(String videoFilename, String thumbFilename) throws IOException,
            InterruptedException
    {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegApp, "-y",
                "-i", videoFilename, "-vframes", "1", "-ss", "00:00:01", "-f", "image2", thumbFilename);

        Process process = processBuilder.start();
        InputStream stderr = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(stderr);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null)
            ;
        process.waitFor();

        if(br != null)
            br.close();
        if(isr != null)
            isr.close();
        if(stderr != null)
            stderr.close();
    }

    public static void main(String[] args)
    {
        UpdateCover videoThumbTaker = new UpdateCover("E:/ffmpeg-20191029-d3dee67-win64-dev/ffmpeg.exe");
        try
        {
            videoThumbTaker.getThumb("http://vodwhqpjupy.vod.126.net/vodwhqpjupy/f7f5eacd-71ec-48ad-883e-4442742bcf47.mp4",
                    "F:/test1.jpg");
            System.out.println("over");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}