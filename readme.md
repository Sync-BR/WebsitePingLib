# Ping Library 

Biblioteca Java para verificar a disponibilidade de sites e normalizar URLs de forma simples e eficiente.

---
## 📥 Instalação

### Maven
Adicione o repositório JitPack e a dependência no seu `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Sync-BR</groupId>
        <artifactId>WebsitePingLib</artifactId>
        <version>v1.0.5</version>
    </dependency>
</dependencies>
```
---

## 📦 Sobre a Biblioteca

A `Ping` é uma biblioteca leve que permite:

- Testar se um site está acessível.
- Normalizar URLs removendo protocolos (`http://`, `https://`), `www.` e barras finais (`/`).
- Lançar exceções personalizadas caso o site não esteja acessível.

Ela é ideal para projetos que precisam validar links, monitorar a disponibilidade de serviços ou padronizar URLs antes de processá-las.

---

## 🛠️ Funcionalidades

### Ping

Classe principal que verifica se um site está acessível:

```java
Ping ping = new Ping();
boolean siteOnline = ping.checkWebSite("https://www.exemplo.com/");
