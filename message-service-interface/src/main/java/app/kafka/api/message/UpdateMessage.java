package app.kafka.api.message;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class UpdateMessage {
    @NotNull
    @NotBlank
    @Property(name = "version")
    public String version;

    @NotNull
    @NotBlank
    @Property(name = "download_link")
    public String link;

    @Property(name = "important_upgrade")
    public Boolean importantUpgrade;

}
