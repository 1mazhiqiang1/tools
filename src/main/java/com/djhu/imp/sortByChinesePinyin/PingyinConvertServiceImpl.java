package com.djhu.imp.sortByChinesePinyin;

import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class PingyinConvertServiceImpl implements IPingyinConvertService {


    /** {@inheritDoc} */
    @Override
    public String convertPingyin(String str) {
        return convertPingyin(str, true);
    }

    /** {@inheritDoc} */
    @Override
    public String convertPingyin(String str, boolean isUpper) {
        if (!containsChinese(str)) {
            return str;
        }

        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        if (isUpper) {
            defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        } else {
            defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        }

        StringBuilder pinyin = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 128) {
                pinyin.append(c);
            } else {
                String[] t = null;
                try {
                    t = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                    log.info("convert char error!!!,char is {}", c);
                }
                if (t == null) {
                    pinyin.append(c);
                } else {
                    String temp = t[0];
                    pinyin.append(temp);
                }
            }
        }
        return pinyin.toString();
    }

    /**
     * 检测该字符串是否含有中文
     *
     * @param str
     * @return
     */
    private boolean containsChinese(String str) {
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (Character.toString(str.toCharArray()[i]).matches("[\\u4E00-\\u9FA5]+")) {
                return true;
            }
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> convertPingyin(List<String> strs) {
        return convertPingyin(strs, true);
    }

    /** {@inheritDoc} */
    @Override
    public List<String> convertPingyin(List<String> strs, boolean isUpper) {
        List<String> wordList = new ArrayList<>();
        for (String str : strs) {
            String word = convertPingyin(str, isUpper);
            wordList.add(word);
        }
        return wordList;
    }

    public static void main(String[] args) {
    /*    PingyinConvertServiceImpl service = new PingyinConvertServiceImpl();
        String xx = service.convertPingyin("张玮123haha!!测试");
        System.out.println(xx);*/


    }
}
