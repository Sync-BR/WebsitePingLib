package com.github.sync.ping.util;

import com.github.sync.ping.enumeration.Domain;
import com.github.sync.ping.handle.DomainHandle;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária responsável por identificar e manipular domínios em URLs.
 * <p>
 * A classe percorre os valores do {@link Domain} para reconhecer domínios conhecidos
 * dentro de uma string de URL e retornar apenas a parte correspondente ao domínio
 * (ex.: transformar {@code "exemple.com.br/D/13938642/"} em {@code "exemple.com.br"}).
 * </p>
 *
 * <p>
 * Caso nenhum domínio seja identificado, será lançada uma exceção {@link DomainHandle}.
 * </p>
 *
 * @author Eduardo
 * @since 1.0
 */
public class DomainIdentify {


    /**
     * Retorna a lista de domínios configurados no enum {@link Domain}.
     * <p>
     * Os nomes definidos no enum (ex.: {@code _COM_BR}) são convertidos
     * para o formato de domínio válido (ex.: {@code .com.br}).
     * </p>
     *
     * @return lista de domínios suportados, em letras minúsculas
     */
    private List<String> getDomain() {
        List<String> domains = new ArrayList<>();
        for (Domain domain : Domain.values()) {
            domains.add(domain.name().replaceAll("_", ".").toLowerCase());
        }
        return domains;
    }

    /**
     * Analisa uma URL e retorna apenas a parte correspondente ao domínio.
     * <p>
     * A lista de domínios conhecidos é ordenada por tamanho decrescente,
     * garantindo que domínios compostos (como {@code .com.br}) tenham prioridade
     * sobre domínios simples (como {@code .com}).
     * </p>
     *
     * <pre>
     * Exemplo de uso:
     * DomainIdentify d = new DomainIdentify();
     * </pre>
     *
     * @param hostUrl URL que será analisada
     * @return string contendo a URL cortada até o domínio
     * @throws DomainHandle caso nenhum domínio conhecido seja encontrado
     */
    public String fixUrl(String hostUrl) {
        List<String> domains = getDomain();

        // Ordena para garantir que .com.br seja testado antes de .com
        domains.sort((a, b) -> Integer.compare(b.length(), a.length()));

        for (String domain : domains) {
            if (hostUrl.contains(domain)) {
                int endIndex = hostUrl.indexOf(domain) + domain.length();
                return hostUrl.substring(0, endIndex);
            }
        }
        throw new DomainHandle("Domain not found");
    }
}
