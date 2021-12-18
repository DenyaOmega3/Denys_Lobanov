package app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class Dropbox {
    private final String generatedKey = "HXedoogjWEoAAAAAAAAAAfWVAvlaXTgUsYb3OakT4cC_zOdb115OwteCm8wz834E";
    private Integer lastGivenStatus;

    public Integer getLastGivenStatus() {
        return lastGivenStatus;
    }

    public void UploadFile(String path, String filename, String bodyText) throws
            com.mashape.unirest.http.exceptions.UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://content.dropboxapi.com/2/files/upload")
                .header("Dropbox-API-Arg", "{\"path\":\""+path+filename+".txt\",\"mode\": \"add\",\"autorename\": true,\"mute\": false,\"strict_conflict\": false}")
                .header("Content-Type", "application/octet-stream")
                .header("Authorization", "Bearer "+generatedKey)
                .body(bodyText)
                .asString();
        lastGivenStatus = response.getStatus();
        response.getBody();
    }

    public void GetFileMetadata(String id) throws
            com.mashape.unirest.http.exceptions.UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.dropboxapi.com/2/sharing/get_file_metadata")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+generatedKey)
                .body("{\r\n    \"file\": \"id:"+id+"\",\r\n    \"actions\": []\r\n}")
                .asString();
        lastGivenStatus = response.getStatus();
        System.out.println(lastGivenStatus);
    }

    public void Delete(String path, String filename) throws
            com.mashape.unirest.http.exceptions.UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api.dropboxapi.com/2/files/delete_v2")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+generatedKey)
                .body("{\r\n    \"path\": \""+path+filename+".txt\"\r\n}")
                .asString();
        lastGivenStatus = response.getStatus();
        System.out.println(lastGivenStatus);
    }
}
