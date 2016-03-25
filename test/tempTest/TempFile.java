package tempTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by yanzi on 2016/3/6.
 */
public class TempFile {
    public static void main(String[] args){
        File f = null;
        try{
            f = File.createTempFile("VIP",".sdp");
            System.out.println("File path: " + f.getAbsolutePath());

            FileOutputStream outputStream = new FileOutputStream(f);
            String str = "m=video 1234 RTP/AVP 96 \n" +
                "a=rtpmap:96 H264 \n" +
                "a=framerate:10 \n" +
                "c=IN IP4 127.0.0.1 \n";
            outputStream.write(str.getBytes());
         //   f.deleteOnExit();



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
