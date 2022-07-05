package com.djhu.imp.utils;

import com.djhu.imp.service.SaveTemplateServiceImpl;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;


/**
 * Created by zhouhs on 2017/1/9.
 */
@Service
public class WordExport {

    public void export(Map<SaveTemplateServiceImpl.TableInfo,List<SaveTemplateServiceImpl.TableEntity>> map)  {
        try {
            //Blank Document
            XWPFDocument document= new XWPFDocument();

            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(new File("create_table.docx"));
            //添加标题
            XWPFParagraph titleParagraph = document.createParagraph();
            //设置段落居中
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);

          /*  XWPFRun titleParagraphRun = titleParagraph.createRun();
            titleParagraphRun.setText("Java PoI");
            titleParagraphRun.setColor("000000");
            titleParagraphRun.setFontSize(20);*/
            this.settingParagraphs(document,map);


            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy policy = null;
            try {
                policy = new XWPFHeaderFooterPolicy(document, sectPr);
//            } catch (XmlException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }

            //添加页眉
            CTP ctpHeader = CTP.Factory.newInstance();
            CTR ctrHeader = ctpHeader.addNewR();
            CTText ctHeader = ctrHeader.addNewT();
            String headerText = "Java POI create MS word file.";
            ctHeader.setStringValue(headerText);
            XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
            //设置为右对齐
            headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
            XWPFParagraph[] parsHeader = new XWPFParagraph[1];
            parsHeader[0] = headerParagraph;
            policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);

            //添加页脚
            CTP ctpFooter = CTP.Factory.newInstance();
            CTR ctrFooter = ctpFooter.addNewR();
            CTText ctFooter = ctrFooter.addNewT();
            String footerText = "http://blog.csdn.net/zhouseawater";
            ctFooter.setStringValue(footerText);
            XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
            headerParagraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFParagraph[] parsFooter = new XWPFParagraph[1];
            parsFooter[0] = footerParagraph;
            policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

            document.write(out);
            out.close();
            System.out.println("create_table document written success.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //设置段落信息
  public void settingParagraphs( XWPFDocument document,Map<SaveTemplateServiceImpl.TableInfo,List<SaveTemplateServiceImpl.TableEntity>> map){
      for (SaveTemplateServiceImpl.TableInfo table:map.keySet()) {
          //段落
          XWPFParagraph firstParagraph = document.createParagraph();
          XWPFRun run = firstParagraph.createRun();
          run.setText(table.getRemark()+"("+table.getTablename()+")");
          //设置字体颜色
          run.setColor("696969");
          run.setFontSize(16);
          run.setBold(true); //加粗


          //设置段落背景颜色
          CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
          cTShd.setVal(STShd.CLEAR);
//          cTShd.setFill("D3D3D3");
          //表格
          XWPFTable ComTable = document.createTable();
          //列宽自动分割
          CTTblWidth comTableWidth = ComTable.getCTTbl().addNewTblPr().addNewTblW();
          comTableWidth.setType(STTblWidth.DXA);
          comTableWidth.setW(BigInteger.valueOf(9072));

          //表格第一行
          XWPFTableRow comTableRowOne = ComTable.getRow(0);
          comTableRowOne.getCell(0).setText("列名");
          comTableRowOne.addNewTableCell().setText("类型");
          comTableRowOne.addNewTableCell().setText("是否空");
          comTableRowOne.addNewTableCell().setText("注释");
          comTableRowOne.getCell(0).setColor("D3D3D3");
          comTableRowOne.getCell(1).setColor("D3D3D3");
          comTableRowOne.getCell(2).setColor("D3D3D3");
          comTableRowOne.getCell(3).setColor("D3D3D3");

          List<SaveTemplateServiceImpl.TableEntity> list = map.get(table);
          for(int i=0;i<list.size();i++){
                XWPFTableRow comTableRowTwo = ComTable.createRow();
                comTableRowTwo.getCell(0).setText(list.get(i).getColumn_name());
                String dataType = list.get(i).getData_type();
                if(dataType.equalsIgnoreCase("VARCHAR2")||dataType.equals("NUMBER")||dataType.equalsIgnoreCase("NVARCHAR2")){
                    comTableRowTwo.getCell(1).setText(list.get(i).getData_type()+"("+list.get(i).getData_length()+")");
                }else{
                    comTableRowTwo.getCell(1).setText(list.get(i).getData_type());
                }

                comTableRowTwo.getCell(2).setText(list.get(i).getNullAble());
                comTableRowTwo.getCell(3).setText(list.get(i).getComments());
          }
          //两个表格之间加个换行
          XWPFParagraph paragraph = document.createParagraph();
          XWPFRun paragraphRun = paragraph.createRun();
          paragraphRun.setText("\r");

      }






  }



}