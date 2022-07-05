package com.djhu.imp.sortByChinesePinyin;


import java.util.List;

/**
 * @author zw
 */
public interface IPingyinConvertService {
    /**
     * 将汉字转换为拼音
     *
     * @param str 输入的汉字
     * @return 返回的拼音
     */
    public String convertPingyin(String str);

    /**
     * 将汉字转换为拼音
     *
     * @param str     输入的汉字
     * @param isUpper true 为大写 false 为小写
     * @return 返回的拼音
     */
    public String convertPingyin(String str, boolean isUpper);


    /**
     * 将汉字转换为拼音 ,默认为大写
     *
     * @param strs 输入的汉字
     * @return 返回的拼音
     */
    public List<String> convertPingyin(List<String> strs);

    /**
     * 将汉字转换为拼音
     *
     * @param strs    输入的汉字
     * @param isUpper true 为大写 false 为小写
     * @return 返回的拼音
     */
    public List<String> convertPingyin(List<String> strs, boolean isUpper);
}
