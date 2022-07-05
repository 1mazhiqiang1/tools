<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,viewport-fit=cover">
    <title>入学通知书</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
        
        .home-page {
            padding: 0;
            margin: 0;
            min-height: 100vh;
            box-sizing: border-box;
            padding-bottom: constant(safe-area-inset-bottom);
            padding-bottom: env(safe-area-inset-bottom);
        }
        
        .home-page .home-content {
            flex: 1;
            background: linear-gradient(180deg, #E8CAAA 0%, #FBF1E4 79%, #E3C4A3 100%);
        }
        
        .home-page .header-box {
            height: 200px;
            background: url('https://hyomo.oss-cn-shanghai.aliyuncs.com/hyp/admission.png') no-repeat;
            background-size: 100% 100%;
            position: relative;
            z-index: 2;
        }
        
        .home-page .header-box .badge-box {
            width: 99px;
            height: 116px;
            position: absolute;
            bottom: -140px;
            left: 0;
            right: 0;
            top: 0;
            margin: auto
        }
        
        .home-page .content-box {
            position: relative;
            width: 100vw;
            top: -2rem;
            z-index: 1;
        }
        
        .home-page .content-animate {
            position: relative;
        }
        
        .home-page .content-animate .bg-box {
            height: 6.4rem;
            background: url('https://hyomo.oss-cn-shanghai.aliyuncs.com/hyp/line_long%402x.png') no-repeat;
            background-size: 100% 100%;
        }
        
        .home-page .content-book {
            min-height: 9.88rem;
            background: url('https://hyomo.oss-cn-shanghai.aliyuncs.com/hyp/paper%402x.png') no-repeat;
            background-size: 100% 100%;
            box-sizing: border-box;
            margin-left: .15rem;
            margin-right: .15rem;
            padding-top: 2.8rem;
            padding-left: 1rem;
            padding-right: 1rem;
            display: flex;
            flex-direction: column;
            padding-bottom: .6rem;
        }
        
        .home-page .content-book .info-box {
            flex: 1;
        }
        
        .home-page .content-book .footer-box {
            height: 1.2rem;
            text-align: right;
            font-size: 14px;
            font-family: SourceHanSerifSC-SemiBold, SourceHanSerifSC;
            font-weight: bold;
            color: #965A0C;
            line-height: 20px;
        }
        
        .company-name {
            font-size: 16px;
            font-family: SourceHanSerifSC-SemiBold, SourceHanSerifSC;
            font-weight: bold;
            color: #666666;
            word-wrap: break-word;
            word-break: normal;
        }
        
        .student-box {
            font-size: 16px;
            font-family: SourceHanSerifSC-SemiBold, SourceHanSerifSC;
            font-weight: bold;
            color: #666666;
            word-wrap: break-word;
            word-break: normal;
        }
        
        .student-box .student-name {
            font-size: 24px;
            font-family: SourceHanSerifCN-Heavy, SourceHanSerifCN;
            font-weight: bold;
            color: #0E0E0E;
            padding-right: .2rem;
        }
        
        .des-info-box {
            font-size: 18px;
            font-family: SourceHanSerifSC-Medium, SourceHanSerifSC;
            color: #464646;
            text-indent: .8rem;
            line-height: 30px;
            word-wrap: break-word;
            word-break: normal;
        }
        
        .course-box {
            font-size: 18px;
            font-family: SourceHanSerifSC-Medium, SourceHanSerifSC;
            font-weight: bold;
            color: #464646;
            text-decoration: underline;
            word-wrap: break-word;
            word-break: normal;
        }
        
        .course-box-item {
            padding-left: .2rem;
        }
        
        .des-info {
            padding-top: .4rem;
        }
        
        .slogan-info-box {
            margin-top: 2.5rem;
            font-size: 16px;
            font-family: PingFangSC-Semibold, PingFang SC;
            font-weight: 600;
            color: #95685F;
            line-height: 22px;
            text-align: center;
        }
        
        .company-logo {
            margin-top: .3rem;
            padding-bottom: .6rem;
            height: 3rem;
            text-align: center;
        }
        
        .company-logo img {
            max-width: 100%;
            max-height: 100%;
        }
        
        .home-page .page-footer-bar {
            height: 3.18rem;
            border-top: 1px dashed #D0170E;
            background-color: #fff;
            box-sizing: border-box;
            display: flex;
            justify-content: space-around;
            align-items: center;
            font-size: 16px;
            font-family: PingFangSC-Medium, PingFang SC;
            font-weight: bold;
            color: #BB843C;
        }
        
        .home-page .qrCode-box {
            width: 78px;
            height: 78px;
            background: #F6EADE;
            border-radius: 8px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .home-page .qrCode-box img {
            width: 66px;
            height: 66px;
        }
        
        .footer-slogan-box {
            font-size: 12px;
            font-family: PingFangSC-Medium, PingFang SC;
            font-weight: 500;
            color: #E50C18;
            display: flex;
            align-items: center;
            padding-top: 8px;
        }
        
        .footer-slogan-box img {
            width: 16px;
            height: 16px;
            margin-right: 3px;
        }
        
        @media screen and (min-width: 415px) {
            .home-page {
                width: 375px;
                text-align: center;
                margin-left: auto;
                margin-right: auto;
                overflow-x: hidden;
                overflow-y: auto;
            }
            .home-page .content-book {
                width: 355px;
            }
            .home-page .content-animate .bg-box {
                width: 375px;
            }
        }
    </style>
</head>

<body>
    <div class="home-page">
        <div class="home-content">
            <div class="header-box">
                <img class="badge-box" src="https://hyomo.oss-cn-shanghai.aliyuncs.com/hyp/badge%402x.png" />
            </div>
            <div class="content-box">
                <div class="content-animate">
                    <div class="bg-box">
                        <div class="content-book">
                            <div class="info-box">
                                <div class="company-name">${entrpriseName}</div>
                                <div class="student-box"><span class="student-name">阿雪华</span>同学：</div>
                                <div class="des-info-box">
                                    欢迎加入
                                    <span class="course-box">《餐饮经营九大定位》11月上海站</span><span class="course-box-item">课程！</span>课程导师为
                                    <span class="course-box">陈新时</span> 老师。
                                </div>
                                <div class="des-info-box des-info">
                                    期待与你一起助推中国餐饮，提升行业幸福！
                                </div>
                            </div>
                            <div class="footer-box">
                                <div>汉源餐饮大学</div>
                                <div>2020年12月01日</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="slogan-info-box">我们在汉源餐饮大学等你！</div>
            <div class="company-logo">
                <img src="https://hyomo.oss-cn-shanghai.aliyuncs.com/hyp/logo%402x.png" />
            </div>
        </div>
        <div class="page-footer-bar">
            <div>
                <div>邀请你来线上试听</div>
                <div>一起突出重围，实现增长！</div>
                <div class="footer-slogan-box">
                    <img src="https://hyomo.oss-cn-shanghai.aliyuncs.com/hyp/icon_Press%402x.png" />
                    <span>长按识别或扫码报名 >></span>
                </div>
            </div>
            <div class="qrCode-box">
                <img src="https://gw.alipayobjects.com/zos/rmsportal/KDpgvguMpGfqaHPjicRK.svg" />
            </div>
        </div>
    </div>
    <script src="http://g.tbcdn.cn/mtb/lib-flexible/0.3.4/??flexible_css.js,flexible.js"></script>
</body>

</html>