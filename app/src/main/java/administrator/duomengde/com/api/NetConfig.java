package administrator.duomengde.com.api;

public class NetConfig {
    public static String BaseUrl;
    //1:正式服务器 2：外测服务器 3：内测服务器
    public static int API_TYPE = 1;
    public static String DQD_BASE1 = "https://";//主机名
    static {
        if (API_TYPE == 1)BaseUrl ="";
        else if (API_TYPE == 2) BaseUrl = "";
        else BaseUrl = "";
    }
}
