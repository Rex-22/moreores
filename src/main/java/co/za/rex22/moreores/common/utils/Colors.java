package co.za.rex22.moreores.common.utils;

public enum Colors {
    NONE(0x00FFFFFF),
    TITANIUM(0xFF7DCBCE);

    private final int color;

    Colors(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

}
