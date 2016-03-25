package tempTest;

import com.wlwz.action.UploadFileAction;

import java.io.File;

/**
 * Created by yanzi on 2016/3/22.
 */
public class DataProcessTest {

    public static void main(String[] args){
        UploadFileAction uploadFileAction = new UploadFileAction();
        uploadFileAction.setFile(new File("D:\\waveletpackage.txt"));
        uploadFileAction.setMethodType("归一化");
        try{
            System.out.println(uploadFileAction.dealWithData());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
