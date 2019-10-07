package com.enter.service.enums;

/**
 * Created by Administrator on 2019/9/30.
 */

public enum FileType implements EnumInterFace{

    /**
     * 图片
     */
    IMAGE(){
        @Override
        public Integer number() {

            return  1;
        }

        @Override
        public String value() {
            return "GIF|PNG|JPG|JPEG";
        }
    },

    /**
     * PPT
     */
    PPT {
        @Override
        public Integer number() {
            return null;
        }

        @Override
        public String value() {
            return null;
        }

        public String getValue() {
            return "PPT";
        }
    },
    /**
     * word文档
     */
    WORD {
        @Override
        public Integer number() {
            return null;
        }

        @Override
        public String value() {
            return null;
        }

        public String getValue() {
            return "WORD|DOC|DOCX|";
        }
    },
    /**
     * 普通文档
     */
    TXT {
        @Override
        public Integer number() {
            return null;
        }

        @Override
        public String value() {
            return null;
        }

        public String getValue() {
            return "TXT|";
        }
    },
    /**
     * 视频
     */
    VIDEO {
        @Override
        public Integer number() {
            return null;
        }

        @Override
        public String value() {
            return null;
        }

        public String getValue() {
            return "MP4|MP3|AVI|DIV";
        }
    },;

}