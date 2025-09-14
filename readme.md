# Ping Library

Biblioteca Java para verificar a disponibilidade de sites e normalizar URLs de forma simples e eficiente.

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
