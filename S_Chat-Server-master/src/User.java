/**
 * Copyright © 2016 WetAQB&DreamCityAdminGroup All right reserved.
 * Welcome to DreamCity Server Address:dreamcity.top:19132
 * Created by WetAQB(Administrator) on 2017/2/4.
 * |||    ||    ||||                           ||        ||||||||     |||||||
 * |||   |||    |||               ||         ||  |      |||     ||   |||    |||
 * |||   |||    ||     ||||||  ||||||||     ||   ||      ||  ||||   |||      ||
 * ||  |||||   ||   |||   ||  ||||        ||| |||||     ||||||||   |        ||
 * ||  || ||  ||    ||  ||      |        |||||||| ||    ||     ||| ||      ||
 * ||||   ||||     ||    ||    ||  ||  |||       |||  ||||   |||   ||||||||
 * ||     |||      |||||||     |||||  |||       |||| ||||||||      |||||    |
 * ||||
 */
import Utils.getMAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class User {

    private String name;
    //private String ip;
    private String account;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private String password;
    private String Mac;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getIp() {
        return socket.getInetAddress().getHostAddress();
    }

    public void setSocket(final Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public String getMac() {
        return Mac;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, final Socket socket) throws IOException {
        this.name = name;
        this.socket = socket;
        //this.ip = address;
        this.br = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        this.pw = new PrintWriter(socket.getOutputStream());
        this.Mac = getMAC.getMacAddress(socket.getInetAddress().getHostAddress());
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", account=" + account + ", socket="
                + socket + "]";
    }
}
