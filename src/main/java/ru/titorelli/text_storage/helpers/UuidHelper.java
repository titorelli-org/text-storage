package ru.titorelli.text_storage.helpers;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.NameBasedGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidHelper {
    private final UUID urlNamespace = UUID.fromString("6ba7b811-9dad-11d1-80b4-00c04fd430c8");
    private final UUID textNamespace = Generators.nameBasedGenerator(urlNamespace).generate("https://text.api.titorelli.ru/text");
    private final UUID statsNamespace = Generators.nameBasedGenerator(urlNamespace).generate("https://text.api.titorelli.ru/stats");
    private final UUID metadataNamespace = Generators.nameBasedGenerator(urlNamespace).generate("https://text.api.titorelli.ru/metadata");
    private final UUID normalizedNamespace = Generators.nameBasedGenerator(urlNamespace).generate("https://text.api.titorelli.ru/text/normalized");
    private final NameBasedGenerator textGenerator = Generators.nameBasedGenerator(textNamespace);
    private final NameBasedGenerator statsGenerator = Generators.nameBasedGenerator(statsNamespace);
    private final NameBasedGenerator metadataGenerator = Generators.nameBasedGenerator(metadataNamespace);
    private final NameBasedGenerator normalizedGenerator = Generators.nameBasedGenerator(normalizedNamespace);

    public String getForText(@NotNull String txt) {
        return textGenerator.generate(txt).toString();
    }

    public String getForNormalizedText(@NotNull UUID uuid) {
        return normalizedGenerator.generate(uuid.toString()).toString();
    }

    public String getForNormalizedText(@NotNull String uuidStr) {
        return normalizedGenerator.generate(uuidStr).toString();
    }

    public String getForStats(@NotNull UUID textUuid) {
        return statsGenerator.generate(textUuid.toString()).toString();
    }

    public String getForStats(@NotNull String textUuidStr) {
        return statsGenerator.generate(textUuidStr).toString();
    }

    public String getForMetadata(@NotNull UUID textUuid) {
        return metadataGenerator.generate(textUuid.toString()).toString();
    }

    public String getForMetadata(@NotNull String textUuidStr) {
        return metadataGenerator.generate(textUuidStr).toString();
    }
}
