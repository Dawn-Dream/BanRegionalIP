package com.DawnDream.BanRegionalIP.getIpRegional;

public class getIp {
    public static final String IP_SITE = "https://whois.pconline.com.cn/ip.jsp?ip=IPSITE";
    public static String ipSite(String ip) {
        String str = HttpClient.doGet(IP_SITE.replaceAll("IPSITE",ip));
        int i = str.indexOf(" ");
        str = str.substring(0,i);
        return str.replace("\n","").replace("\r","");
    }
    public static void main(String[] args) {
        String s = getIp.ipSite("117.136.40.55");

        System.err.println(s);
        System.out.println("awa");
    }
}
