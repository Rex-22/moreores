package co.za.rex22.moreores.common.utils;

public enum MiniralType {
    TITANIUM("titanium", Colors.TITANIUM, ToolProperties.TITANIUM, BlockProperties.TITANIUM)
    ;

    private final String name;
    private final Colors color;
    private ToolProperties toolProperties;
    private BlockProperties blockProperties;

    MiniralType(String name, Colors color, ToolProperties toolProperties, BlockProperties blockProperties) {
        this.name = name;
        this.color = color;
        this.toolProperties = toolProperties;
        this.blockProperties = blockProperties;
    }

    public Colors getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public ToolProperties getToolProperties() {
        return toolProperties;
    }

    public BlockProperties getBlockProperties() {
        return blockProperties;
    }
}
