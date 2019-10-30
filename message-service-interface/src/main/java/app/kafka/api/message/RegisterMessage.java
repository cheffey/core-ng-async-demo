package app.kafka.api.message;

import core.framework.api.json.Property;
import core.framework.api.validate.Min;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

public class RegisterMessage {
    @NotNull
    @NotBlank
    @Property(name = "id")
    public String id;

    @Min(0)
    @Property(name = "reward")
    public Integer reward;
}
