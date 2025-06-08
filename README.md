# 📦 Paper Message Manager

O objetivo deste projeto é implementar o novo formato de mensagens que a biblioteca [Adventu API](https://docs.advntr.dev/getting-started.html) fornece através da [MiniMessage](https://docs.advntr.dev/minimessage/format.html) com o antigo formato de mensagens do Bukkit, permitindo que os desenvolvedores possam utilizar o novo formato de mensagens sem prejudicar o formato antigo.
Também foi adicionado uma verificação de permissão para envio de mensagens que sejam de ação, como por exemplo ``<click:run_command:/seed>Click</click> to show the world seed!``, as ações configuradas são [click](https://docs.advntr.dev/minimessage/format.html#click), [selector](https://docs.advntr.dev/minimessage/format.html#selector) e [nbt](https://docs.advntr.dev/minimessage/format.html#nbt).

## 🛠️ Instalação

Para instalar e começar a utilizar é simples, basta inserir os seguintes trechos no seu arquivo `pom.yml`:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/henriquemb/papermessagemanager</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>com.github.henriquemb</groupId>
        <artifactId>papermessagemanager</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```

## ⚙️ Uso

Para utilizar o Paper Message Manager, basta importar a classe `MessageManager` e utilizar os métodos disponíveis para converter mensagens entre os formatos do Bukkit e do MiniMessage.

```java
import com.github.henriquemb.papermessagemanager.manager.MessageManager;
import org.bukkit.command.CommandSender;

public class MessageSender {
    private static final MessageManager messageManager = new MessageManager("*");
    
    public static void sendMessage(CommandSender player, CommandSender target, String message) {
        messageManager.sendMessage(player, target, message);
    }

    public static void sendMessage(CommandSender target, String message) {
        messageManager.sendMessage(target, message);
    }

    public static void sendActionBar(CommandSender player, CommandSender target, String message) {
        messageManager.sendActionBar(player, target, message);
    }

    public static void sendActionBar(CommandSender target, String message) {
        messageManager.sendActionBar(target, message);
    }
}
```

A permissão é verificada em cima do ``player`` e a mensagem é enviada para o ``target``, caso o ``player`` seja nulo, todas as ações são removidas da mensagem.

## 🤝 Contribuição

Contribuições são bem-vindas! Se você quiser contribuir com o projeto, sinta-se à vontade para abrir um pull request ou relatar problemas.