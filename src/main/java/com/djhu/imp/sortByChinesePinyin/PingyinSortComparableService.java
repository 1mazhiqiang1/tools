package com.djhu.imp.sortByChinesePinyin;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//@Service
public class PingyinSortComparableService<T> implements Comparator<T> {

    public static final String ASC = "asc";
    public static final String DESC = "desc";

    private IPingyinConvertService pingyinConvertService = new PingyinConvertServiceImpl();

    private String reverse = ASC;

    /** {@inheritDoc} */
    @Override
    public int compare(T lDictInfo, T rDictInfo) {
        String lpingyin = "";
        String rpingyin = "";
       /* if (DictInfo.class.isInstance(lDictInfo)) {
            DictInfo ldictInfo = (DictInfo) lDictInfo;
            DictInfo rdictInfo = (DictInfo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getTypename());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getTypename());
        } else if (OptionVo.class.isInstance(lDictInfo)) {
            OptionVo ldictInfo = (OptionVo) lDictInfo;
            OptionVo rdictInfo = (OptionVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getTypename());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getTypename());
        } else if(TbDiagnosticCode.class.isInstance(lDictInfo)){
            TbDiagnosticCode ldictInfo = (TbDiagnosticCode) lDictInfo;
            TbDiagnosticCode rdictInfo = (TbDiagnosticCode) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getName());
        } else if(TbDetaelementconfigVo.class.isInstance(lDictInfo)){
            TbDetaelementconfigVo ldictInfo = (TbDetaelementconfigVo) lDictInfo;
            TbDetaelementconfigVo rdictInfo = (TbDetaelementconfigVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getInetMdcodeName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getInetMdcodeName());
        } else if(DeptNormalSearchfield.class.isInstance(lDictInfo)){
            DeptNormalSearchfield ldictInfo = (DeptNormalSearchfield) lDictInfo;
            DeptNormalSearchfield rdictInfo = (DeptNormalSearchfield) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getSearchFieldName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getSearchFieldName());
        } else if(TbDetaelementconfig.class.isInstance(lDictInfo)){
            TbDetaelementconfig ldictInfo = (TbDetaelementconfig) lDictInfo;
            TbDetaelementconfig rdictInfo = (TbDetaelementconfig) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getInetMdcodeName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getInetMdcodeName());
        } else if(TbExportFieldSetting.class.isInstance(lDictInfo)){
            TbExportFieldSetting ldictInfo = (TbExportFieldSetting) lDictInfo;
            TbExportFieldSetting rdictInfo = (TbExportFieldSetting) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getInetMdcodeName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getInetMdcodeName());
        } else if(SearchResultField.class.isInstance(lDictInfo)){
            SearchResultField ldictInfo = (SearchResultField) lDictInfo;
            SearchResultField rdictInfo = (SearchResultField) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getInteName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getInteName());
        } else if(TbRormDefVo.class.isInstance(lDictInfo)){
            TbRormDefVo ldictInfo = (TbRormDefVo) lDictInfo;
            TbRormDefVo rdictInfo = (TbRormDefVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getFromName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getFromName());
        } else if(TbDbFormdef.class.isInstance(lDictInfo)){
            TbDbFormdef ldictInfo = (TbDbFormdef) lDictInfo;
            TbDbFormdef rdictInfo = (TbDbFormdef) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getFromName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getFromName());
        } else if(TbDiagnosticCodeVo.class.isInstance(lDictInfo)){
            TbDiagnosticCodeVo ldictInfo = (TbDiagnosticCodeVo) lDictInfo;
            TbDiagnosticCodeVo rdictInfo = (TbDiagnosticCodeVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getDiagnosticName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getDiagnosticName());
        } else if(TbInteMappingMdhcVo.class.isInstance(lDictInfo)){
            TbInteMappingMdhcVo ldictInfo = (TbInteMappingMdhcVo) lDictInfo;
            TbInteMappingMdhcVo rdictInfo = (TbInteMappingMdhcVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getInteMdname());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getInteMdname());
        } else if(Map.class.isInstance(lDictInfo)){
            Map ldictInfo = (Map) lDictInfo;
            Map rdictInfo = (Map) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(StringUtil.isValue(ldictInfo.getOrDefault("dataName","")));
            rpingyin = pingyinConvertService.convertPingyin(StringUtil.isValue(rdictInfo.getOrDefault("dataName","")));
        }  else if(TbOperationVo.class.isInstance(lDictInfo)){
            TbOperationVo ldictInfo = (TbOperationVo) lDictInfo;
            TbOperationVo rdictInfo = (TbOperationVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getOperationName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getOperationName());
        } else if(TbUserGroupVo.class.isInstance(lDictInfo)){
            TbUserGroupVo ldictInfo = (TbUserGroupVo) lDictInfo;
            TbUserGroupVo rdictInfo = (TbUserGroupVo) rDictInfo;
            lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getUserGroupName());
            rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getUserGroupName());
        }*/
        SearchPathConditionVo ldictInfo = (SearchPathConditionVo) lDictInfo;
        SearchPathConditionVo rdictInfo = (SearchPathConditionVo) rDictInfo;
        lpingyin = pingyinConvertService.convertPingyin(ldictInfo.getName());
        rpingyin = pingyinConvertService.convertPingyin(rdictInfo.getName());
        if (reverse.equalsIgnoreCase(ASC)) {
            return lpingyin.compareTo(rpingyin);
        } else {
            return rpingyin.compareTo(lpingyin);
        }
    }


    public static void main(String[] args) {
        PingyinSortComparableService pingyinSortComparableService = new PingyinSortComparableService();
        List<SearchPathConditionVo> list = new ArrayList<>();
        SearchPathConditionVo searchPathConditionVo3 = new SearchPathConditionVo();
        searchPathConditionVo3.setName("测");
        list.add(searchPathConditionVo3);
        SearchPathConditionVo searchPathConditionVo1 = new SearchPathConditionVo();
        searchPathConditionVo1.setName("啊");
        list.add(searchPathConditionVo1);
        SearchPathConditionVo searchPathConditionVo2 = new SearchPathConditionVo();
        searchPathConditionVo2.setName("别");
        list.add(searchPathConditionVo2);
        Collections.sort(list,pingyinSortComparableService);
        for (SearchPathConditionVo vo:list) {
            System.out.println(vo.getName());
        }
    }


}
