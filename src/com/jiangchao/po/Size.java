package com.jiangchao.po;

public enum Size {
    // 四个实例
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbriviation;

    Size(String abbriviation) {
        this.abbriviation = abbriviation;
    }

    Size() {
    }

   /* @Override
    public String toString() {
        return "Size{" +
                "abbriviation='" + abbriviation + '\'' +
                ", name='" + name() + '\'' +
                ", ordinal=" + ordinal() +
                '}';
    }*/

    public String getAbbriviation() {
        return abbriviation;
    }

    public static void main(String[] args) {
        Size.SMALL.toString();
        Enum.valueOf(Size.class, "SMALL");
    }
}
