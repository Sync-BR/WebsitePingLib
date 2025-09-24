package com.github.sync.ping;

import com.github.sync.ping.handle.HttpRequestException;
import com.github.sync.ping.util.DomainIdentify;
import com.github.sync.ping.util.FixUrl;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
    public FixUrl urlFix;
    public DomainIdentify identify;

    public boolean checkWebSite(String hostUrl) {
        try {
            urlFix = new FixUrl();
            this.identify = new DomainIdentify();
            InetAddress address = InetAddress.getByName(identify.fixUrl(urlFix.checkPattern(hostUrl)));
            if (address.isReachable(5000)) {
                return true;
            } else {
                throw new HttpRequestException("Erro ao tentar acessar o site: não foi possível completar a requisição. Verifique se o site está no ar ou se há problemas de rede.");
            }
        } catch (IOException e) {
            throw new HttpRequestException("Erro ao tentar acessar o site: não foi possível completar a requisição. Verifique se o site está no ar ou se há problemas de rede.");
        }
    }



}
