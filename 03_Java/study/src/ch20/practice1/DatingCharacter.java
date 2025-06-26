package ch20.practice1;

import lombok.Getter;

public class DatingCharacter implements Comparable<DatingCharacter>, CharacterType {
    @Getter
    private String name;
    private String personality;
    private String hobby;
    private String favoriteFood;
    @Getter
    private String talkStyle;
    private String typeCode;

    public DatingCharacter () {
    }

    private DatingCharacter (String name, String personality, String hobby, String favoriteFood, String talkStyle, String typeCode) {
        this.name = name;
        this.personality = personality;
        this.hobby = hobby;
        this.favoriteFood = favoriteFood;
        this.talkStyle = talkStyle;
        this.typeCode = typeCode;
    }

    public static Builder builder () {
        return new Builder();
    }

    @Override
    public int compareTo (DatingCharacter o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString () {
        return "이름: " + name + " / 성격: " + personality + " / 유형: " + typeCode;
//        return "[✨ 추천 결과 ✨]\n" +
//                "이름: " + name + "\n" +
//                "성격: " + personality + "\n" +
//                "취미: " + hobby + "\n" +
//                "좋아하는 음식: " + favoriteFood + "\n" +
//                "말투 스타일: " + talkStyle;
//        return "이름: " + name + " / 성격: " + personality + " / 취미: " + hobby;
    }

    @Override
    public String getTypeCode () {
        return typeCode;
    }

    public static class Builder {
        private String name;
        private String personality;
        private String hobby;
        private String favoriteFood;
        private String talkStyle;
        private String typeCode;

        private Builder () {
        }

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder personality (String personality) {
            this.personality = personality;
            return this;
        }

        public Builder hobby (String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Builder favoriteFood (String favoriteFood) {
            this.favoriteFood = favoriteFood;
            return this;
        }

        public Builder talkStyle (String talkStyle) {
            this.talkStyle = talkStyle;
            return this;
        }

        public Builder typeCode (String typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public DatingCharacter build () {
            return new DatingCharacter(name, personality, hobby, favoriteFood, talkStyle, typeCode);
        }
    }
}
