package com.github.sync.ping.util;
/**
 * Classe utilitária para normalizar URLs.
 * Permite remover protocolos (http/https), "www." e barras finais.
 */
public class FixUrl {

    /**
     * Remove o protocolo "http://" ou "https://" do início da URL.
     *
     * @param url URL original
     * @return URL sem o protocolo
     */
    private String fixProtocols(String url){
        return url.replaceAll("https?://", "");
    }

    /**
     * Remove "www." do início da URL.
     *
     * @param url URL que pode conter "www."
     * @return URL sem o "www."
     */
    private String fixWorldWideWeb(String url){
        return url.replaceAll("^(https?://)?www\\.", "");

    }

    /**
     * Remove a barra "/" do final da URL, se existir.
     *
     * @param url URL que pode terminar com "/"
     * @return URL sem a barra final
     */
    private String fixFinalUrl(String url){
        return url.replaceAll("/$", "");
    }

    /**
     * Aplica todas as correções na URL de forma sequencial:
     * 1. Remove protocolo http/https
     * 2. Remove "www."
     * 3. Remove barra final "/"
     *
     * @param hostUrl URL original
     * @return URL normalizada
     */
    public String checkPattern(String hostUrl){
        hostUrl = fixProtocols(hostUrl);
        hostUrl = fixWorldWideWeb(hostUrl);
        hostUrl = fixFinalUrl(hostUrl);
        return hostUrl;

    }

}
