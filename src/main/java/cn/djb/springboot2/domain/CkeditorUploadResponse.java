package cn.djb.springboot2.domain;

public class CkeditorUploadResponse {
    private int uploaded;
    private String fileName;
    private String url;
    private Object error;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public int getUploaded() {
        return uploaded;
    }



    public String getUrl() {
        return url;
    }


    public void setUploaded(int uploaded) {
        this.uploaded = uploaded;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
