package com.example.qimendunjia.utils;

import com.example.qimendunjia.model.QiMenData;
import java.util.*;

public class QiMenAnalyzerEnhanced {

    // ==================== 资料库：九干克应完整版 ====================
    private static final Map<String, String> JIU_GAN_KE_YING = new HashMap<String, String>() {{
        // 甲或戊类
        put("戊戊", "①①戊加戊：伏吟格，凡事闭塞，静守为吉。");
        put("戊乙", "①⑨戊乙：青龙合灵格，门吉事吉，门凶事凶。");
        put("戊丙", "①⑧戊丙：青龙返首格，动作大吉，若逢迫、墓、击、刑，吉事成凶。");
        put("戊丁", "①⑦戊丁：青龙耀明格，谒贵求名吉利，若值墓、迫，招是招非。");
        put("戊己", "①②戊己：贵人入狱格，公私皆不利。");
        put("戊庚", "①③戊庚：值符飞宫格，吉事不吉，凶事更凶。");
        put("戊辛", "①④戊辛：青龙折足格，吉门生助尚可谋为，若逢凶门，主招灾、失财、有足疾。");
        put("戊壬", "①⑤戊壬：青龙入天牢格，凡阴阳皆不吉利。");
        put("戊癸", "①⑥戊癸：青龙华盖格，吉格者吉，招福，门凶多乖。");

        // 乙类
        put("乙戊", "⑨①乙加戊：利阴害阳格，门逢凶迫，财破人伤。");
        put("乙乙", "⑨⑨乙乙：日奇伏吟格，不宜谒贵求名，只可安分守身。");
        put("乙丙", "⑨⑧乙丙：奇仪顺遂格，吉星迁官进职，凶星夫妻离别。");
        put("乙丁", "⑨⑦乙丁：奇仪相佐格，文书事吉，百事皆可为。");
        put("乙己", "⑨②乙己：日奇入雾格，被土暗昧，门凶必凶，得三吉门为地遁。");
        put("乙庚", "⑨③乙庚：日奇被刑格，争讼财产，夫妻怀私。");
        put("乙辛", "⑨④乙辛：青龙逃走格，奴仆拐带，六畜皆伤。");
        put("乙壬", "⑨⑤乙壬：日奇入地格，尊卑悖乱，官讼是非。");
        put("乙癸", "⑨⑥乙癸：华盖逢星官格，宜遁迹修道，隐匿藏形，躲灾避难为吉。");

        // 丙类
        put("丙戊", "⑧①丙加戊：飞鸟跌穴格，谋为百事洞澈。");
        put("丙乙", "⑧⑨丙乙：日月并行格，公谋私为皆吉。");
        put("丙丙", "⑧⑧丙丙：月奇孛师格，文书逼迫，破耗遗失。");
        put("丙丁", "⑧⑦丙丁：月奇朱雀格，贵人文书吉利，常人平静，得三吉门为天遁。");
        put("丙己", "⑧②丙己：太孛入刑格，囚人刑杖，文书不行，吉门得吉，凶门转凶。");
        put("丙庚", "⑧③丙庚：荧入太白格，门户破败，盗贼耗失。");
        put("丙辛", "⑧④丙辛：谋事就成格，病人不凶。");
        put("丙壬", "⑧⑤丙壬：火入天罗格，为客不利，是非颇多。");
        put("丙癸", "⑧⑥丙癸：华盖孛师格，阴人害事，灾祸频生。");

        // 丁类
        put("丁戊", "⑦①丁加戊：青龙转光格，官人升迁，常人威昌。");
        put("丁乙", "⑦⑨丁乙：人遁吉格，贵人加官进爵，常人婚姻财喜。");
        put("丁丙", "⑦⑧丁丙：星随月转格，贵人越级高升，常人乐里生悲。");
        put("丁丁", "⑦⑦丁丁：奇入太阴格，文书即至，喜事遂心。");
        put("丁己", "⑦②丁己：火入勾陈格，奸私雠冤，事因女人。");
        put("丁庚", "⑦③丁庚：年月日时格，文书阻隔，行人必归。");
        put("丁辛", "⑦④丁辛：朱雀入狱格，罪人释囚，官人失位。");
        put("丁壬", "⑦⑤丁壬：五神互合格，贵人恩昭，讼狱公平。");
        put("丁癸", "⑦⑥丁癸：朱雀投江格，文书口舌俱消，音信沉溺。");

        // 己类
        put("己戊", "②①己加戊：犬遇青龙格，门吉谋望遂意，上人见喜，门凶枉劳心机。");
        put("己乙", "②⑨己乙：墓神不明格，地户蓬星，宜遁迹隐形为利逸。");
        put("己丙", "②⑧己丙：火孛地户格，阳人冤枉相害，阴人必致淫污。");
        put("己丁", "②⑦己丁：朱雀入墓格，文状词讼，先曲后直。");
        put("己己", "②②己己：地户逢鬼格，病者必死，百事不遂。");
        put("己庚", "②③己庚：刑格，求名、词讼先动者不利，阴星有谋害之情。");
        put("己辛", "②④己辛：游魂入墓格，大人鬼魅，小人家先为祟。");
        put("己壬", "②⑤己壬：地网高张格，狡童佚女，奸情杀伤。");
        put("己癸", "②⑥己癸：地刑玄武格，男女疾病垂危，词讼有囚狱之灾。");

        // 庚类
        put("庚戊", "③①庚加戊：太白天乙伏宫格，百事不可谋为凶。");
        put("庚乙", "③⑨庚乙：太白蓬星格，退吉进凶。");
        put("庚丙", "③⑧庚丙：太白入荧格，占贼必来，为客进利，为主破财。");
        put("庚丁", "③⑦庚丁：亭亭之格，因私昵起官司，门吉有救。");
        put("庚己", "③②庚己：刑格，官司被重刑。");
        put("庚庚", "③③庚庚：太白同宫格，官灾横祸，兄弟雷攻。");
        put("庚辛", "③④庚辛：白虎干格，远行车折马死。");
        put("庚壬", "③⑤庚壬：远行失迷道路，男女音信嗟呀。");
        put("庚癸", "③⑥庚癸：大格，行人至官司止，生产母子俱伤，大凶。");

        // 辛类
        put("辛戊", "④①辛加戊：困龙被伤格，官司破败，屈抑守分，妄动祸殃。");
        put("辛乙", "④⑨辛乙：白虎猖狂格，人亡家败，远行多殃，尊长不喜，车船俱伤。");
        put("辛丙", "④⑧辛丙：干合孛师格，荧惑出现，占雨无，占晴旱，占事必因财致讼。");
        put("辛丁", "④⑦辛丁：狱神得奇格，经商获倍利，因人逢赦宥。");
        put("辛己", "④②辛己：入狱自刑格，奴仆背主，讼诉难伸。");
        put("辛庚", "④③辛庚：白虎出力格，刀刃相接，主客相残，逊让退步，稍可强进，血溅衣衫。");
        put("辛辛", "④④辛辛：伏吟天庭格，公废私就，讼狱自罹罪名。");
        put("辛壬", "④⑤辛壬：凶蛇入狱格，两男争女，讼狱不息，先动失理。");
        put("辛癸", "④⑥辛癸：天牢华盖格，日月失明，误入天网，动止乖张。");

        // 壬类
        put("壬戊", "⑤①壬加戊：小蛇化龙格，男人发达，女产婴童。");
        put("壬乙", "⑤⑨壬乙：小蛇格，女子柔顺，男人嗟呀，占孕生子，禄马光华。");
        put("壬丙", "⑤⑧壬丙：水蛇入火格，官灾刑禁络绎不绝。");
        put("壬丁", "⑤⑦壬丁：干合蛇刑格，文书牵连，贵人匆匆，男凶女吉。");
        put("壬己", "⑤②壬己：凶蛇入狱格，大祸将至，顺守斯吉，词讼理曲。");
        put("壬庚", "⑤③壬庚：太白擒蛇格，刑狱公平，立剖邪正。");
        put("壬辛", "⑤④壬辛：螣蛇相缠格，纵得吉门，亦不能安，若有谋望，被人欺瞒。");
        put("壬壬", "⑤⑤壬壬：蛇入地罗格，外人缠绕，内事索索，门吉星凶，庶免蹉跎。");
        put("壬癸", "⑤⑥壬癸：幼女奸淫格，家有丑声，门星俱吉，反祸福隆。");

        // 癸类
        put("癸戊", "⑥①癸加戊：天乙会合格，财喜婚姻，吉人赞助成合，若门凶迫制，反招官非。");
        put("癸乙", "⑥⑨癸乙：华盖蓬星格，贵人禄位，常人平安。");
        put("癸丙", "⑥⑧癸丙：华盖孛师格，贵贱逢之，上人见喜。");
        put("癸丁", "⑥⑦癸丁：螣蛇妖矫格，文书官司，火焚莫逃。");
        put("癸己", "⑥②癸己：华盖地户格，男女占之，书信皆阻，躲灾避难为吉。");
        put("癸庚", "⑥③癸庚：太白入网格，以暴争讼力平。");
        put("癸辛", "⑥④癸辛：网盖天牢格，占讼占病，死罪莫逃。");
        put("癸壬", "⑥⑤癸壬：复见螣蛇格，嫁娶重婚，后嫁无子，不保年华。");
        put("癸癸", "⑥⑥癸癸：天网四张格，行人失伴，病讼皆伤。");
    }};

    // ==================== 资料库：三奇到宫克应完整版 ====================
    private static final Map<String, String> SAN_QI_DAO_GONG = new HashMap<String, String>() {{
        // 乙奇到宫
        put("乙乾", "乙奇到乾：有人着黄衣至，或扛钱过为应。后六十日内进商音人财产，大发。");
        put("乙坎", "乙奇到坎：有人着皂衣至，或有鼓声为应，后七日得财。");
        put("乙艮", "乙奇到艮：有人着白衣至，或缠物来，或用网里鱼来为应，后一年内进人口，若有人送家禽来者，大吉。");
        put("乙震", "乙奇到震：有渔猎人至，并小儿二人同来为应，后七日内进财宝，若闻有东方产亡者，大发。");
        put("乙巽", "乙奇到巽：有白衣人骑马过，或小儿作戏耍为应，后三年内生贵子，进东方财产，若闻东方人家失火，或有缢死者，必大发。");
        put("乙离", "乙奇到离：有人着色衣为应，后三十日进横财，若闻东方有刀刃自杀者，必大发。");
        put("乙坤", "乙奇到坤：有三、五人至为应，后七日进横财，六十日进文契，若闻南方有雷、牛畜者，大发。");
        put("乙兑", "乙奇到兑：有三、五少妇至，或鸟鹊成群为应，后三日，或三十日进角音人财大发，或生牛马者，横发。");

        // 丙奇到宫
        put("丙乾", "丙奇到乾：有披衣人至，或鸟鹊成队飞来为应，后月内进寡妇财产、文契，若闻南方有生产者，发旺。");
        put("丙坎", "丙奇到坎：有瞽目人至，及北方有鸟飞来为应，后百日或一年因水火生财大富。");
        put("丙艮", "丙奇到艮：有人着青衣至，小儿哭泣或童子手拿铜铁器物为应，后七日内进财宝，周年内进白马发旺。");
        put("丙震", "丙奇到震：有武大将军器至，若春天有雷声或鼓声为应，后十日内外进古铜器，一年内生贵子，北方有龙雷震者，必大发。");
        put("丙巽", "丙奇到巽：有鼓音歌乐为应，后七日有色衣人至，家招横财，若闻南方有大惊者，必然横发。");
        put("丙离", "丙奇到离：有黄色飞禽成对来为应，后或一、七日或六十日进坑壠田蚕发旺。");
        put("丙坤", "丙奇到坤：有皂衣人至，或鸟鹊在南方鸣为应，后二、七日进南方人财物，或一年内进牛羊及绝户人财产，大发。若闻东方鼓声更吉。");
        put("丙兑", "丙奇到兑：有人持杖并拿酒器及抱小儿为应，后更有鼓乐之声，七日进财，周年内进人财及坤艮二方财产，大发。");

        // 丁奇到宫
        put("丁乾", "丁奇到乾：有人持刀刃至或牵马过为应，后二、七日内或七十日内动土得财，大发。");
        put("丁坎", "丁奇到坎：有人抱小儿来，南方云雨至，黑禽自西方来为应，百日内有喜庆婚姻事大吉。");
        put("丁艮", "丁奇到艮：有人与小儿打狗为应，后七日或七十日内进黄黑色活物，半年内进人口及田契发旺。");
        put("丁震", "丁奇到震：有二女子着青衣至，或双夫妇至，或黑白禽自南方来为应，后七十日内进黄白活物，大发。");
        put("丁巽", "丁奇到巽：有小儿骑马过，南方云起，北方下雨为应，后周年人落水淹死，妇人产亡凶。");
        put("丁离", "丁奇到离：有蹶足人或瞎眼人至，及小儿骑马过为应，后七十日内因火生财，发旺。");
        put("丁坤", "丁奇到坤：有女人着青衣至，与僧道同行，或黑牛拉车为应，后七十日内因水破财致败。");
        put("丁兑", "丁奇到兑：有人抱文书印簿至，或赶牛羊鹿为应，后六十日内进田宅致富。");
    }};

    // ==================== 资料库：三奇到宫断语 ====================
    private static final Map<String, String> SAN_QI_DAO_GONG_DUAN = new HashMap<String, String>() {{
        put("乙乾", "六乙到乾名曰「玉兔入天门」，吉。天冲、天辅加六宫，在季夏、秋月或庚辛酉申日，有白色气来助，主胜。一名「玉兔入林」。");
        put("丙乾", "六丙到乾名为「天成天权」，凶。有白云气从西北或西方来助，主胜。天英加六宫，在夏秋月有赤色云气来助，客胜。一名「光明不全」。");
        put("丁乾", "六丁到乾名为「火到天门」，吉。丙丁巳午日有赤色云气从正南方来助，客胜。一名「玉女游天门」，又名「火照天门」。");

        put("乙坎", "六乙到坎名为「玉兔投泉」，吉。天英加一宫在秋冬月或壬癸亥子日，有黑色云气从正北方来助，主胜。一名「玉兔饮泉」。");
        put("丙坎", "六丙到坎名为「丙火烧壬」，吉，主胜。天任、天禽、天芮加一宫在四季月或辰戌丑未日，一名「火投水池」。");
        put("丁坎", "六丁到坎名曰「朱雀投江」，中吉。有黄色云气从东北或西南方来助，客胜。");

        put("乙艮", "六乙到艮名为「玉兔步贵」，吉。天蓬临八宫，在四季月或戊己辰戌丑未日，有黄色云气来助，主胜。");
        put("丙艮", "六丙到艮名为「凤入丹山」，吉。有黄色云气从东北或西南方来助，主胜。天辅、天冲加八宫在冬春月。");
        put("丁艮", "六丁到艮名为「玉女乘云」，吉。甲乙寅卯日有青色云气从正东或东南方来助，客胜。一名「玉女游鬼门」。");

        put("乙震", "六乙到震名为「日出扶桑」，吉。天任、天禽、天芮临三宫，在冬夏月或甲乙寅卯日，有青云来助，主胜。即贵人升乙卯正殿。");
        put("丙震", "六丙到震名为「月入雷门」，吉。有云气从正东或东南方来助，主胜。天柱、天任加三宫，在季秋月。");
        put("丁震", "六丁到震名曰「最明」，吉。庚辛申酉日有白云气从正西或西北方来助，客胜。");

        put("乙巽", "六乙到巽名曰「玉兔乘风」，吉。天任、天禽、天芮临四宫，在冬春月或甲乙寅卯日，有青色云气来助，主胜。");
        put("丙巽", "六丙到巽名曰「火行风起」，又为「龙神助威」吉。东南方神旺，主胜。天心、天柱加四宫在季夏秋月。");
        put("丁巽", "六丁到巽名曰「美女留神」吉。或庚辛申酉日，有白色云气从正西或西北方来助，客胜。");

        put("乙离", "六乙到离名曰「玉兔当阳」，吉。天柱、天心加九宫，在春夏月或丙丁巳午日，有赤色云气来助，主胜。");
        put("丙离", "六丙到离名曰「月照端门」，吉。有云气从正南方来助，主胜。天蓬加九宫，在秋月或壬癸日，即贵人升丙午正殿。");
        put("丁离", "六丁到离名曰「乘龙万里」。壬癸亥子日，有黑色云从正北方来助，客胜。");

        put("乙坤", "六乙到坤名曰「玉兔入坤」，中吉。天蓬临二宫在四季月或戊己辰戌丑未日，有黄色云气从北方来助，主胜。一名「玉兔暗日」。");
        put("丙坤", "六丙到坤名曰「子居母舍」，吉。云气从西南方来助，主胜。天辅、天冲加二宫，在冬春月或甲日吉。");
        put("丁坤", "六丁到坤名为「玉女游地」，吉。甲乙寅卯日有青色云气从正东或东南来助，客胜，大吉。一名「玉女游地户」，吉。");

        put("乙兑", "六乙到兑名为「玉女受制」，平平。天冲、天辅加七宫，在季夏、秋月或庚辛申酉日，有白色云气来助，主胜。一名「白兔游宫」，吉。");
        put("丙兑", "六丙到兑名曰「凤凰折翅」，凶。白云气从正西或西北方来助，主胜。天英加七宫在春夏月及丙日，客胜。");
        put("丁兑", "六丁到兑，平平。丙丁巳午日，有赤云气从南方来助，客胜。一云：丁见兑为天乙贵人，即为贵升于丁酉正殿，大吉。");
    }};

    // ==================== 资料库：星门克应完整版 ====================
    private static final Map<String, String> XING_MEN_KE_YING = new HashMap<String, String>() {{
        // 天蓬
        put("天蓬休", "①①蓬休：披枷戴锁，锒铛入狱小凶");
        put("天蓬生", "①⑧蓬生：纵欲无度，尽兴不返大吉");
        put("天蓬伤", "①③蓬伤：大难临头，六宅不安小凶");
        put("天蓬杜", "①④蓬杜：十年寒窗，不得一举小凶");
        put("天蓬景", "①⑨蓬景：万事具备，只欠东风小凶");
        put("天蓬死", "①②蓬死：夺戒口食，剥戒身衣小凶");
        put("天蓬惊", "①⑦蓬惊：别生枝节，何所取义小凶");
        put("天蓬开", "①⑥蓬开：三年不鸣，一鸣惊人大吉");

        // 天芮
        put("天芮休", "②①芮休：一以当千，南争北战大吉");
        put("天芮生", "②⑧芮生：力不从心，望尘莫及小凶");
        put("天芮伤", "②③芮伤：七窃生烟，九世之仇小凶");
        put("天芮杜", "②④芮杜：安生而食，用钱如水小凶");
        put("天芮景", "②⑨芮景：才情卓越，大智若愚小吉");
        put("天芮死", "②②芮死：日落西山，旦不保夕大凶");
        put("天芮惊", "②⑦芮惊：风吹草动，一夕数惊小凶");
        put("天芮开", "②⑥芮开：堆金积玉，安富尊荣大吉");

        // 天冲
        put("天冲休", "③①冲休：履险如夷，转危为安大吉");
        put("天冲生", "③⑧冲生：塞翁失马，安之非福大吉");
        put("天冲伤", "③③冲伤：遍体鳞伤，痛入骨髓大凶");
        put("天冲杜", "③④冲杜：墨守成规，不知改变小凶");
        put("天冲景", "③⑨冲景：车载斗量，指不胜屈小吉");
        put("天冲死", "③②冲死：刀光剑影，枕戈待旦小凶");
        put("天冲惊", "③⑦冲惊：遇人不淑，劳燕分飞大凶");
        put("天冲开", "③⑥冲开：力行不怠，一日千重大吉");

        // 天辅
        put("天辅休", "④①辅休：雾消云散，重见光明大吉");
        put("天辅生", "④⑧辅生：心心相印，海誓山盟大吉");
        put("天辅伤", "④③辅伤：先天不足，后天未补小凶");
        put("天辅杜", "④④辅杜：七颠八倒，自相矛盾大凶");
        put("天辅景", "④⑨辅景：春风一度，始乱终弃小吉");
        put("天辅死", "④②辅死：花天酒地，玩物丧志小凶");
        put("天辅惊", "④⑦辅惊：天罗地网，插翅难飞小凶");
        put("天辅开", "④⑥辅开：字无分文，牛衣对泣小凶");

        // 天禽
        put("天禽休", "⑤①禽休：披枷戴锁，锒铛入狱小凶");
        put("天禽生", "⑤⑧禽生：前山后海，进退两难小凶");
        put("天禽伤", "⑤③禽伤：遍体鳞伤，痛入骨髓大凶");
        put("天禽杜", "⑤④禽杜：七颠八倒，自相矛盾大凶");
        put("天禽景", "⑤⑨禽景：春风一度，始乱终弃小凶");
        put("天禽死", "⑤②禽死：日落西山，旦不保夕大凶");
        put("天禽惊", "⑤⑦禽惊：投机取巧，惟利是图大凶");
        put("天禽开", "⑤⑥禽开：四海漂泊，何处是家小凶");

        // 天心
        put("天心休", "⑥①心休：官明如镜，吏清如水大吉");
        put("天心生", "⑥⑧心生：六根清净，山林隐逸大吉");
        put("天心伤", "⑥③心伤：飞来横祸，轩然大波小凶");
        put("天心杜", "⑥④心杜：山穷水尽，千辛万苦大凶");
        put("天心景", "⑥⑨心景：相见恨晚，握手言欢小吉");
        put("天心死", "⑥②心死：生死有命，回天乏术小凶");
        put("天心惊", "⑥⑦心惊：千变万化，不可捉摸小凶");
        put("天心开", "⑥⑥心开：四海漂泊，何处是家小凶");

        // 天柱
        put("天柱休", "⑦①柱休：孤云野鹤，枕流漱石大吉");
        put("天柱生", "⑦⑧柱生：怜我怜卿，鸾凤和鸣大吉");
        put("天柱伤", "⑦③柱伤：上下其手，一手遮天大凶");
        put("天柱杜", "⑦④柱杜：七颠八倒，自相矛盾大凶");
        put("天柱景", "⑦⑨柱景：先著祖鞭，长治久安小吉");
        put("天柱死", "⑦②柱死：引狼入室，虎视耽耽小凶");
        put("天柱惊", "⑦⑦柱惊：投机取巧，惟利是图大凶");
        put("天柱开", "⑦⑥柱开：有勇有谋，果决前进大吉");

        // 天任
        put("天任休", "⑧①任休：因材施教，青出于蓝大吉");
        put("天任生", "⑧⑧任生：前山后海，进退两难小凶");
        put("天任伤", "⑧③任伤：饥不择食，饮鸩止渴小凶");
        put("天任杜", "⑧④任杜：积劳成疾，病入膏肓小凶");
        put("天任景", "⑧⑤任景：衣暖食饱，琼楼玉宇小吉");
        put("天任死", "⑧②任死：明目张胆，坐地分赃大凶");
        put("天任惊", "⑧⑦任惊：一无所得，人财两空小凶");
        put("天任开", "⑧⑥任开：仓斗库实，有备无患大吉");

        // 天英
        put("天英休", "⑨①英休：寸进尺退，一事无成小凶");
        put("天英生", "⑨⑧英生：游山玩水，走遍天下大吉");
        put("天英伤", "⑨③英伤：龙争虎斗，两败俱伤小凶");
        put("天英杜", "⑨④英杜：倚官仗势，作威作福小凶");
        put("天英景", "⑨⑨英景：春风一度，始乱终弃小凶");
        put("天英死", "⑨②英死：连年征战，劳民伤财小凶");
        put("天英惊", "⑨⑦英惊：目瞪口呆，方寸已乱小凶");
        put("天英开", "⑨⑥英开：金碧辉煌，前呼后拥大吉");
    }};

    // ==================== 资料库：八门克应完整版 ====================
    private static final Map<String, String> MEN_KE_YING = new HashMap<String, String>() {{
        // 开门
        put("开开", "⑥⑥开门加开：主贵人、宝物、财喜。");
        put("开休", "⑥①开休：主见贵人、财喜，更主开张铺店，贸易大利。");
        put("开生", "⑥⑧开生：主见贵人、谋望，所求皆遂。");
        put("开伤", "⑥③开伤：主变动，更改、移徙事皆不吉。");
        put("开杜", "⑥④开杜：失脱刊印书契小凶。");
        put("开景", "⑥⑨开景：主见贵人，因文书事不利。");
        put("开死", "⑥②开死：主官司惊忧，先忧后喜。");
        put("开惊", "⑥⑦开惊：主百事不利。");

        // 休门
        put("休休", "①①休门加休：求财、进人口、谒贵吉。朝见、上官修，大利。");
        put("休生", "①⑧休生：主得阴人财物并干贵，谋望迟应吉。");
        put("休伤", "①③休伤：主上官喜庆，求财不得，有亲故分产变动事，不吉。");
        put("休杜", "①④休杜：主破财，失物难寻。");
        put("休景", "①⑨休景：主求望、文书印信事不至，反招口舌，小凶。");
        put("休死", "①②休死：主求文书印信、官司事，或僧道远行事，不吉。占病，凶。");
        put("休惊", "①⑦休惊：主损财招益，并疾病惊恐事，破财不利。");
        put("休开", "①⑥休开：主开张店肆及见贵、求财、喜庆事，大吉。");

        // 生门
        put("生生", "⑧⑧生门加生：主远行、求财产吉。");
        put("生伤", "⑧③生伤：主亲友变动道路不吉。");
        put("生杜", "⑧④生杜：主阴谋，阴人破财，不利。");
        put("生景", "⑧⑨生景：主阴人、小口不寍及文书事后吉。");
        put("生死", "⑧②生死：主田宅官司主难救。");
        put("生惊", "⑧⑦生惊：主尊长财产词讼及病缠迟愈吉。");
        put("生开", "⑧⑥生开：主见贵人，求财大发。");
        put("生休", "⑧①生休：主阴人处求望财利吉。");

        // 伤门
        put("伤伤", "③③伤门加伤：主变动，远行皆折伤，凶。");
        put("伤杜", "③④伤杜：主变动、失脱、官司、桎梏，百事凶。");
        put("伤景", "③⑨伤景：主文书、印信、口舌、动挠、啾喞。");
        put("伤死", "③②伤死：主官司、印信，凶。出行，大忌。占病，凶。");
        put("伤惊", "③⑦伤惊：主亲人疾病忧惧，谋伐不利，凶。");
        put("伤开", "③⑥伤开：主贵人，开张有走失变动之事，不利。");
        put("伤休", "③①伤休：主阳人变动，或托人谋干财名不利。");
        put("伤生", "③⑧伤生：主房产、种植事业，凶。");

        // 杜门
        put("杜杜", "④④杜门加杜：主因父母疾病、田宅出脱事，凶。");
        put("杜景", "④⑨杜景：主文书印信阻隔，阳人、小口疾病，迟疑不利。");
        put("杜死", "④②杜死：主田宅；文书失落，官司破财，小凶。");
        put("杜惊", "④⑦杜惊：主门户内忧疑惊恐，并有词讼事。");
        put("杜开", "④⑥杜开：主见贵人、官长，谋事主先破己财后吉。");
        put("杜休", "④①杜休：主求财有益。");
        put("杜生", "④⑧杜生：主阳人小口破财，及田宅求财不成。");
        put("杜伤", "④③杜伤：主兄弟相争，田产破财。");

        // 景门
        put("景景", "⑨⑨景门加景：主文状未动，有预先见之意，内有阳人小口忧患。");
        put("景死", "⑨②景死：主官讼，因田宅事争，多啾唧。");
        put("景惊", "⑨⑦景惊：主阳人、小口疾病事，凶。");
        put("景开", "⑨⑥景开：主官人升迁吉，求文印更吉。");
        put("景休", "⑨①景休：主文书遗失，争讼不休。");
        put("景生", "⑨⑧景生：主阴人生产大喜，更主求财旺利，行人皆吉。");
        put("景伤", "⑨③景伤：主姻亲眷小口角，或嫌隙挠乱。");
        put("景杜", "⑨④景杜：主失脱文书，散财后平。");

        // 死门
        put("死死", "②②死门加死：主官司而留，印信无气，凶。");
        put("死惊", "②⑦死惊：主因官司不给，忧疑、患病，凶。");
        put("死开", "②⑥死开：主见贵人，求印信、文书事，大利。");
        put("死休", "②①死休：主求财物事不吉，若问僧道求方吉。");
        put("死生", "②⑧死生：主丧事，求财得。占病，死者复生。");
        put("死伤", "②③死伤：主官司动而被刑杖，凶。");
        put("死杜", "②④死杜：主破财，妇人风疾，腹肿，阻绝凶。");
        put("死景", "②⑨死景：主因文契、印信、财产事见官，先怒后喜，不凶。");

        // 惊门
        put("惊惊", "⑦⑦惊门加惊：主疾病、忧虑、惊疑。");
        put("惊开", "⑦⑥惊开：主忧疑、官司、惊恐，又主上见喜，不凶。");
        put("惊休", "⑦①惊休：主求财事，或因口舌、求财事，迟吉。");
        put("惊生", "⑦⑧惊生：主因妇人生忧惊，或因求财生忧惊，皆吉。");
        put("惊伤", "⑦③惊伤：主因商议同谋害人事泄，惹讼，凶。");
        put("惊杜", "⑦④惊杜：主因失脱破财、惊恐，不凶。");
        put("惊景", "⑦⑨惊景：主词讼不息及小口疾病。");
        put("惊死", "⑦②惊死：主因宅中怪异而生是非，凶。");
    }};

    // ==================== 资料库：八神克应 ====================
    private static final Map<String, String> SHEN_KE_YING = new HashMap<String, String>() {{
        put("值符", "值符主长者、贵人、公吏、钱物为应。");
        put("腾蛇", "腾蛇主官司牵连、罗网、推风送雨，及惊恐、怪异为应。");
        put("太阴", "太阴主贤人及夫妇阴私之事为应。");
        put("六合", "六合主华彩、车、书、酒食、筵会、婚姻为应。");
        put("白虎", "白虎主医巫、死丧、秽气、钱物为应。");
        put("玄武", "玄武主惊盗贼及逃亡口舌事为应。");
        put("九地", "九地主女人、衣服、稻豆、埋葬、走兽为应。");
        put("九天", "九天主文书、印信、鎗棒、火灾、占天、飞鸟为应。");
    }};

    // ==================== 资料库：九星类象 ====================
    private static final Map<String, String> XING_LEI_XIANG = new HashMap<String, String>() {{
        put("天蓬", "天蓬星：代表大盗、破财、能做大事业的人，贪酒贪色，有魄力。利于安抚边境。");
        put("天芮", "天芮星：病星，代表求学、求道、求仙之人，学生学员。利于交友。");
        put("天冲", "天冲星：代表武士、处事雷厉风行，有慈爱之心，助人为乐。利于征伐战斗、报仇解怨、施恩交友。");
        put("天辅", "天辅星：代表文化、老师、漂亮。利于教育、经商、婚嫁、发展文化教育。");
        put("天禽", "天禽星：代表方正、厚道人，具有领导才能，有影响力。利于见上级、经商、婚嫁。");
        put("天心", "天心星：代表医生、圆形、有心计人，能动能静，有领导才能。利于医疗、经商、婚嫁、求谋、进见领导。");
        put("天柱", "天柱星：代表凶灾、破败，喜杀好战、惊恐怪异。利于建造营垒、训练士兵。");
        put("天任", "天任星：代表吉利、厚道人，诚信、稳重但偏于执拗。利于安民、入官见贵、经商、婚嫁。");
        put("天英", "天英星：代表烈性、砖窑，性躁易暴、好胜，有才华、喜展现。利于上官见贵、应举报书、饮宴作乐。");
    }};

    // ==================== 资料库：八门类象 ====================
    private static final Map<String, String> MEN_LEI_XIANG = new HashMap<String, String>() {{
        put("休", "休门：代表休养生息、休息、退休之人、婚姻、谒贵、酒、油、盐、水产养殖、休闲、肾、血液。利于接待、婚姻、求财。");
        put("生", "生门：代表生产、生育、养殖、房屋、房地产、利润、利息、经营求财、活物、生长。利于求财造屋、上官赴任。");
        put("伤", "伤门：代表伤灾、疾病、跑动、伤害、残疾、车辆、船只、打斗、战争、赌博。利于讨债、捕捉、赌博。");
        put("杜", "杜门：代表保密、技术、警察、公安、安全部门、不通、堵塞。利于躲灾避难、防洪筑堤。");
        put("景", "景门：代表文书、字据、合同、景致、风景、血光、光明、火电、计划、前景、学校、道路、手机、信息。利于献策筹谋、选士荐贤。");
        put("死", "死门：代表死亡、刑戮、战争、伤疤、疼痛、痛苦、压抑、结束、最后、地皮、阴宅。利于吊死送丧、刑戮战争。");
        put("惊", "惊门：代表口舌、官非、破损、争吵、惊恐、打官司、律师、演说、翻译。利于斗讼官司、抢捕盗贼。");
        put("开", "开门：代表开始、最初、原始、开创、创始人、开业、领导、法官、飞机、门面、办公室、官运、公开。利于开店、求财、上官赴任。");
    }};

    // ==================== 资料库：八神类象 ====================
    private static final Map<String, String> SHEN_LEI_XIANG = new HashMap<String, String>() {{
        put("值符", "值符：诸神之首，所到之处百恶消散。代表长者、贵人、公吏、钱物、资本、银行、领导、核心人物。");
        put("腾蛇", "腾蛇：虚诈神，性柔口毒，专司惊恐怪异、虚诈不实之事。主官司牵连、惊恐怪异、变化多端、虚伪、做梦、绳索、捆绑。");
        put("太阴", "太阴：阴佑神，性阴匿暗昧，好阴匿、暗昧，具护佑之功。利密谋策划、避难藏身，多与女人、阴私之事有关。");
        put("六合", "六合：护卫神，性平和，司婚姻交易中介绍之事。开朗平和、利交易、谈判、中介、合作、婚姻。");
        put("白虎", "白虎：凶恶刚猛神，性好杀，司兵戈争斗杀伐病死。主威权、财帛、犬马、金银宝物、孝服哭泣、血光、骨折。");
        put("玄武", "玄武：奸谗盗神，性好阴谋贼害，司盗贼逃亡口舌事。主聪明多智、文章巧技、奸诈小人、女子阴私、偷盗。");
        put("九地", "九地：坚牢神，性柔好静。主柔顺虚恭之事，为坚牢、稳固之神。利屯兵固守、潜藏万物、屯集、播种、农事活动。");
        put("九天", "九天：威悍神，性刚好动。主名正言顺之事，威悍之神，利扬兵布阵，行军出兵，擂鼓呐喊、张扬、公开、飞机。");
    }};

    // ==================== 资料库：十二地支类象 ====================
    private static final Map<String, String> DI_ZHI_LEI_XIANG = new HashMap<String, String>() {{
        put("子", "子水：代表首领、名人、智慧、聪明、豪奢、阴私、奸邪、暗昧、色欲、悲泣、丢失。");
        put("丑", "丑土：代表忠厚、正直、贤良、福德、职称、难堪、丑陋、田宅、房屋、财产、争斗、诅咒、冤仇。");
        put("寅", "寅木：代表开始、发挥、实际、变化、进行、木器、文章、文艺、艺术、教育、管理、婚姻、喜庆。");
        put("卯", "卯木：代表逃亡、振动、摇摆、急促、消耗、失盗、流动、文化、艺术、欢乐、祥和。");
        put("辰", "辰土：代表斗争、死丧、困难、牢狱、官司、迟滞、玩恶、坚硬、凶怪、打架、动摇、惊恐。");
        put("巳", "巳火：代表信息、惊扰、怪异、争斗、口舌、流血、变化、乞索、讨债、赏赐、奖赏、聪明、狡诈。");
        put("午", "午火：代表富商、名人、经理、善良的人、爱骑马的人、文化人、广告、导演、演员、电业、烧伤。");
        put("未", "未土：代表口味、味道、酒食、宴会、婚姻、喜庆、拜神、召见、会见、小的收获。");
        put("申", "申金：代表运动、传递、道路、疾病、精神、意识、交易、失脱、问题、阻隔、困难。");
        put("酉", "酉金：代表密谋、筹划、策划、缜密、精致、细节、完美、金融、经济、市场、交易、买卖。");
        put("戌", "戌土：代表欺诈、虚伪、虚耗、虚假、思考、空虚、伪装、虚幻、缥缈、茫然、精神、宗教。");
        put("亥", "亥水：代表惊讶、胆怯、流动、光明、召见、隐私、脏脏、偷盗、目眩、恍惚、困难、疑惑。");
    }};

    // ==================== 资料库：十天干类象 ====================
    private static final Map<String, String> TIAN_GAN_LEI_XIANG = new HashMap<String, String>() {{
        put("甲", "甲木：为首、为头、为尊、为长、为盖、为冠、为青龙、为贪狼。代表首长、首领、导师、队长、君子、创始人。");
        put("乙", "乙木：为颈、为项、为辅、为副、为承、为托、为六合、为小龙。代表丞相、副手、助理、二把手、长女。");
        put("丙", "丙火：为光、为电、为明、为亮、为喜、为乐、为飞鸟、为朱雀。代表喜神、文秘、中女、热心人。");
        put("丁", "丁火：为火、为热、为星、为灯、为象、为色、为腾蛇、为鹰雀。代表美女、模特、文人、作家、演员。");
        put("戊", "戊土：为土、为山、为屋、为坡、为墙、为台、为勾陈、为天空。代表山人、市侩、吝啬鬼、大腹人。");
        put("己", "己土：为地、为坛、为园圃、为田园、为乡居、为麒麟、为祥瑞。代表老母、农夫、乡人、群众、记者。");
        put("庚", "庚金：为金、为车、为道路、为走廊、为运动、为白虎、为武备。代表向导、路人、军人、警察、强盗。");
        put("辛", "辛金：为金、为珠玉、为宝贝、为金融、为货币、为歌妓、为太阴。代表少女、婢妾、伶人、音乐人。");
        put("壬", "壬水：为水、为江河、为水渠、为波浪、为弓轮、为智慧。代表中男、渔人、船夫、退休人员、闲人。");
        put("癸", "癸水：为水、为淫、为墨、为污浊、为偷盗、为渣滓、为垃圾。代表盗贼、骗子、黑道、江湖人物。");
    }};

    // ==================== 资料库：常用凶格 ====================
    private static final Map<String, String> XIONG_GE = new HashMap<String, String>() {{
        put("伏吟", "伏吟格：本星或本门伏于本宫。遇此利主不利客，破财伤人，唯宜收敛财货。");
        put("反吟", "反吟格：星或门落入对宫。遇此利客不利主，遇事速度快，或半途而废，求财无力反蚀本，近病则愈，远病难愈。");
        put("青龙逃走", "青龙逃走：乙加辛。主客皆伤，百事不利。");
        put("白虎猖狂", "白虎猖狂：辛加乙。家败人亡，百事凶。");
        put("腾蛇夭矫", "腾蛇夭矫：癸加丁。官非口舌，百事皆凶。");
        put("朱雀投江", "朱雀投江：丁加癸。惊恐怪异，口舌官非。");
        put("荧入太白", "荧惑入太白：丙加庚。战宜回避，不可冲击。");
        put("太白入荧", "太白入荧惑：庚加丙。占凶必来，利客不利主。");
        put("大格", "大格：庚加癸。图谋未遂，求人不见。");
        put("小格", "小格：庚加壬。又称移荡格，遇事多有变动，不宜出师。");
        put("刑格", "刑格：庚加己。求名、词讼先动者不利，阴星有谋害之情。");
        put("悖格", "悖格：丙加值符，值符加丙，或丙加年月日时上，做事无序，求财尽早抽身。");
        put("天网四张", "天网四张：癸加癸。此时不宜举事，举事则祸。");
        put("门迫", "门迫：门克宫为迫，吉门被迫就不吉，凶门被迫祸重重。");
    }};

    // ==================== 资料库：常用吉格 ====================
    private static final Map<String, String> JI_GE = new HashMap<String, String>() {{
        put("青龙返首", "青龙返首：戊加丙。除病以外百事吉，若遇击刑则变凶。");
        put("飞鸟跌穴", "飞鸟跌穴：丙加戊。百事大吉，遇病则凶。");
        put("天遁", "天遁：生门合天盘丙奇，下临地盘丁奇。宜行兵、献策、摄王侯之权，百事生旺。");
        put("地遁", "地遁：开门合天盘乙奇，临地下六己。宜安葬、埋伏、出门、造屋一切皆吉。");
        put("人遁", "人遁：休门与天盘丁奇合太阴。宜密探、隐迹、谒贵、招贤、求亲、经营、对敌。");
        put("风遁", "风遁：乙奇合休开生临巽。宜顺风击敌，以火攻敌。");
        put("云遁", "云遁：乙合开休生，下临六辛宫。宜藏形、蔽敌。");
        put("龙遁", "龙遁：休门与天盘乙奇临坎宫。宜祭龙神、祈求雨泽、掩捕贼人、修桥、穿井、水战。");
        put("虎遁", "虎遁：乙奇合辛临生门于艮宫。宜招安、亡命及战用急攻，必胜。");
        put("神遁", "神遁：天盘丙奇合九天临生门。宜祷神灵、行神术、造坛、驱邪、呼风召雨。");
        put("鬼遁", "鬼遁：生门与丁奇、九地临艮。宜哨探贼机、偷营刦寨、设伪为伏虚、驱神役鬼。");
        put("真诈", "真诈：开休生合三奇，下临太阴。利施恩、隐遁、祈祷、求仙。");
        put("重诈", "重诈：开休生合三奇，下临九地。宜收降、添兵、进人口、纳财、袭爵。");
        put("休诈", "休诈：开休生合三奇，下临六合。宜合药、法符、祈神、禳灾、祭祀。");
        put("天假", "天假：景门合乙丙丁三奇，下临九天。宜陈事、利便、进谒、干求之事。");
        put("地假", "地假：杜门合丁己癸，下临九地。宜潜藏、埋伏，遁迹藏形。");
        put("物假", "物假：伤门合丁己，下临六合。利求物。");
        put("鬼假", "鬼假：死门合丁己癸，下临九地。利超亡、荐度。");
    }};

    // ==================== 资料库：六仪击刑 ====================
    private static final Map<String, String> JI_XING = new HashMap<String, String>() {{
        put("甲子戊震", "甲子戊直符加三宫：六仪击刑，资本耗失，难受、压力大、疲劳、损失、受伤、车祸、受批评。");
        put("甲戌己坤", "甲戌己值符加二宫：六仪击刑，精神崩溃、心里难受、苦不堪言、工作压力大、受到批评。");
        put("甲申庚艮", "甲申庚加八宫：六仪击刑，工作压力大，精神压力大，受到批评，资产受损。");
        put("甲午辛离", "甲午辛加九宫：六仪击刑，资金受损，身体受伤，遭遇车祸，司机疲劳。");
        put("甲辰壬巽", "甲辰壬加四宫：六仪击刑，资金耗失、资产流失、物资受损、产品霉烂。");
        put("甲寅癸巽", "甲寅癸值符加四宫：六仪击刑，资产流失，产品霉烂。");
    }};

    // ==================== 资料库：奇仪入墓 ====================
    private static final Map<String, String> QI_YI_RU_MU = new HashMap<String, String>() {{
        put("乙坤", "乙奇入墓坤宫，主事遇到麻烦，做事犹豫不决，有志难伸。");
        put("丙乾", "丙奇入墓乾宫，诸事不宜为，遇事无能为力。");
        put("丁艮", "丁奇入墓艮宫，主事遇到麻烦，近期遇到麻烦。");
        put("戊乾", "戊入墓乾宫，资金被困，钱财暂时短缺。");
        put("己坤", "己入墓坤宫，犹豫不决，有志难伸。");
        put("庚艮", "庚入墓艮宫，阻力消失，对手处于弱势。");
        put("辛巽", "辛入墓巽宫，错误被掩盖，但需防问题爆发。");
        put("壬巽", "壬入墓巽宫，天网低，难以发展。");
        put("癸坤", "癸入墓坤宫，地网蒙头，难以发展。");
    }};

    // ==================== 资料库：空亡解读 ====================
    private static final Map<String, String> KONG_WANG_JIE_DU = new HashMap<String, String>() {{
        put("甲子旬", "甲子旬中戌亥空，乾宫空亡，主领导、长辈、大城市之事落空。");
        put("甲戌旬", "甲戌旬中申酉空，兑、坤二宫空亡，主口舌、是非之事暂消。");
        put("甲申旬", "甲申旬中午未空，离、坤二宫空亡，主文书、婚姻之事不成。");
        put("甲午旬", "甲午旬中辰巳空，巽宫空亡，主事业、名誉之事虚浮。");
        put("甲辰旬", "甲辰旬中寅卯空，艮、震二宫空亡，主山林、运动之事受阻。");
        put("甲寅旬", "甲寅旬中子丑空，坎、艮二宫空亡，主水边、田宅之事不实。");
    }};

    // ==================== 资料库：马星解读 ====================
    private static final Map<String, String> MA_XING_JIE_DU = new HashMap<String, String>() {{
        put("坎", "马星在坎，主变动在水边，或与水利、水产、流动有关之事。");
        put("坤", "马星在坤，主变动在田野，或与土地、房产、农村有关之事。");
        put("震", "马星在震，主变动在东方，或与交通、运动、奔跑有关之事。");
        put("巽", "马星在巽，主变动在东南，或与风、信息、传播有关之事。");
        put("乾", "马星在乾，主变动在西北，或与城市、领导、高层有关之事。");
        put("兑", "马星在兑，主变动在西方，或与口舌、歌唱、娱乐有关之事。");
        put("艮", "马星在艮，主变动在东北，或与山、静止、停止有关之事。");
        put("离", "马星在离，主变动在南方，或与火、光明、文化有关之事。");
    }};

    // ==================== 九宫名称转数字 ====================
    private static final Map<String, Integer> GONG_NAME_TO_NUM = new HashMap<String, Integer>() {{
        put("坎", 1); put("坤", 2); put("震", 3); put("巽", 4);
        put("中", 5); put("乾", 6); put("兑", 7); put("艮", 8); put("离", 9);
    }};

    // ==================== 数字转九宫名称 ====================
    private static final Map<Integer, String> NUM_TO_GONG_NAME = new HashMap<Integer, String>() {{
        put(1, "坎"); put(2, "坤"); put(3, "震"); put(4, "巽");
        put(5, "中"); put(6, "乾"); put(7, "兑"); put(8, "艮"); put(9, "离");
    }};

    // ==================== 九宫方位 ====================
    private static final Map<Integer, String> GONG_FANG_WEI = new HashMap<Integer, String>() {{
        put(1, "正北"); put(2, "西南"); put(3, "正东"); put(4, "东南");
        put(5, "中央"); put(6, "西北"); put(7, "正西"); put(8, "东北"); put(9, "正南");
    }};

    // ==================== 九宫五行 ====================
    private static final Map<Integer, String> GONG_WU_XING = new HashMap<Integer, String>() {{
        put(1, "水"); put(2, "土"); put(3, "木"); put(4, "木");
        put(5, "土"); put(6, "金"); put(7, "金"); put(8, "土"); put(9, "火");
    }};

    // ==================== 九宫人体部位 ====================
    private static final Map<Integer, String> GONG_REN_TI = new HashMap<Integer, String>() {{
        put(1, "肾脏、膀胱、泌尿系统、血液、耳、肛门");
        put(2, "腹部、脾、胃、肌肉、右肩");
        put(3, "足、肝胆、左胁、神经");
        put(4, "股、肱、胆、气管、神经、左肩");
        put(5, "心、脾胃");
        put(6, "头、骨、肺、大肠、右腿");
        put(7, "口、舌、咽喉、肺、右胁");
        put(8, "鼻、背、手指、关节、左腿、脾、胃");
        put(9, "目、心、上焦、头部");
    }};

    // ==================== 九星本位 ====================
    private static final Map<String, Integer> XING_BEN_WEI = new HashMap<String, Integer>() {{
        put("天蓬", 1); put("天芮", 2); put("天冲", 3); put("天辅", 4);
        put("天禽", 5); put("天心", 6); put("天柱", 7); put("天任", 8); put("天英", 9);
    }};

    // ==================== 八门本位 ====================
    private static final Map<String, Integer> MEN_BEN_WEI = new HashMap<String, Integer>() {{
        put("休", 1); put("生", 8); put("伤", 3); put("杜", 4);
        put("景", 9); put("死", 2); put("惊", 7); put("开", 6);
    }};

    // ==================== 九星顺序 ====================
    private static final String[] XING_ORDER = {"天蓬", "天芮", "天冲", "天辅", "天禽", "天心", "天柱", "天任", "天英"};

    // ==================== 洛书顺时针顺序 ====================
    private static final int[] LUO_SHU_CLOCKWISE = {1, 8, 3, 4, 9, 2, 7, 6};
    private static final int[] LUO_SHU_COUNTER = {1, 6, 7, 2, 9, 4, 3, 8};

    /**
     * 执行完整的析盘和断局（增强版）
     */
    public static QiMenData analyzeEnhanced(QiMenData data) {
        StringBuilder analysis = new StringBuilder();
        StringBuilder interpretation = new StringBuilder();
        Map<Integer, String> gongAnalysis = new HashMap<>();

        analysis.append("========== 析盘内容 ==========\n\n");

        // ==================== 1. 用神分析 ====================
        analysis.append("【用神分析】\n");
        String riGan = data.getDayGanZhi().substring(0, 1); // 日干
        String shiGan = data.getHourGanZhi().substring(0, 1); // 时干
        String yueGan = data.getMonthGanZhi().substring(0, 1); // 月干
        String nianGan = data.getYearGanZhi().substring(0, 1); // 年干

        analysis.append("日干(").append(riGan).append(")代表求测者本人\n");
        analysis.append("时干(").append(shiGan).append(")代表所测之事\n");
        analysis.append("月干(").append(yueGan).append(")代表同辈、朋友、同事\n");
        analysis.append("年干(").append(nianGan).append(")代表长辈、领导\n\n");

        // ==================== 2. 逐宫详细分析 ====================
        analysis.append("【九宫详细分析】\n");
        for (int gong = 1; gong <= 9; gong++) {
            StringBuilder gongResult = new StringBuilder();
            String gongName = NUM_TO_GONG_NAME.get(gong);
            String fangWei = GONG_FANG_WEI.get(gong);
            String wuXing = GONG_WU_XING.get(gong);
            String renTi = GONG_REN_TI.get(gong);

            gongResult.append("◆ ").append(gongName).append(gong).append("宫（").append(fangWei).append("，五行").append(wuXing).append("）：\n");
            gongResult.append("  对应人体：").append(renTi).append("\n");

            // 获取各元素
            String tianGan = data.getTianPanJiuGan().get(gong);
            String diGan = data.getDiPan().get(gong);
            String tianXing = data.getTianPanXing().get(gong);
            String renMen = data.getBaMen().get(gong);
            String shen = data.getBaShen().get(gong);

            if (tianGan != null) gongResult.append("  天盘干：").append(tianGan).append(" ").append(TIAN_GAN_LEI_XIANG.get(tianGan)).append("\n");
            if (diGan != null) gongResult.append("  地盘干：").append(diGan).append(" ").append(TIAN_GAN_LEI_XIANG.get(diGan)).append("\n");
            if (tianXing != null) gongResult.append("  天盘星：").append(tianXing).append(" ").append(XING_LEI_XIANG.get(tianXing)).append("\n");
            if (renMen != null) gongResult.append("  人盘门：").append(renMen).append("门 ").append(MEN_LEI_XIANG.get(renMen)).append("\n");
            if (shen != null) gongResult.append("  神盘：").append(shen).append(" ").append(SHEN_LEI_XIANG.get(shen)).append("\n");

            // 九干克应
            if (tianGan != null && diGan != null) {
                String ganKey = tianGan + diGan;
                if (JIU_GAN_KE_YING.containsKey(ganKey)) {
                    gongResult.append("  ★ ").append(JIU_GAN_KE_YING.get(ganKey)).append("\n");
                }
            }

            // 三奇到宫
            if (tianGan != null && ("乙".equals(tianGan) || "丙".equals(tianGan) || "丁".equals(tianGan))) {
                String qiKey = tianGan + gongName;
                if (SAN_QI_DAO_GONG.containsKey(qiKey)) {
                    gongResult.append("  ★ ").append(SAN_QI_DAO_GONG.get(qiKey)).append("\n");
                }
                if (SAN_QI_DAO_GONG_DUAN.containsKey(qiKey)) {
                    gongResult.append("  ★ ").append(SAN_QI_DAO_GONG_DUAN.get(qiKey)).append("\n");
                }
            }

            // 星门克应
            if (tianXing != null && renMen != null) {
                String xingMenKey = tianXing + renMen;
                if (XING_MEN_KE_YING.containsKey(xingMenKey)) {
                    gongResult.append("  ★ ").append(XING_MEN_KE_YING.get(xingMenKey)).append("\n");
                }
            }

            // 八门克应
            if (renMen != null) {
                String menKey = renMen + renMen;
                if (MEN_KE_YING.containsKey(menKey)) {
                    gongResult.append("  ★ ").append(MEN_KE_YING.get(menKey)).append("\n");
                }
            }

            // 八神克应
            if (shen != null && SHEN_KE_YING.containsKey(shen)) {
                gongResult.append("  ★ ").append(SHEN_KE_YING.get(shen)).append("\n");
            }

            // 检查入墓
            if (isRuMu(tianGan, gong)) {
                String key = tianGan + gongName;
                if (QI_YI_RU_MU.containsKey(key)) {
                    gongResult.append("  ★ ").append(QI_YI_RU_MU.get(key)).append("\n");
                }
            }

            // 检查击刑
            String jiXingKey = getJiXingKey(tianGan, gong);
            if (jiXingKey != null && JI_XING.containsKey(jiXingKey)) {
                gongResult.append("  ★ ").append(JI_XING.get(jiXingKey)).append("\n");
            }

            gongResult.append("\n");
            analysis.append(gongResult.toString());
            gongAnalysis.put(gong, gongResult.toString());
        }

        // ==================== 3. 值符值使分析 ====================
        analysis.append("【值符值使分析】\n");
        String zhiFuXing = data.getZhiFuXing();
        int zhiFuGong = data.getZhiFuLuoGong();
        String zhiFuGongName = NUM_TO_GONG_NAME.get(zhiFuGong);
        String zhiShiMen = data.getZhiShiMen();
        int zhiShiGong = data.getZhiShiLuoGong();
        String zhiShiGongName = NUM_TO_GONG_NAME.get(zhiShiGong);

        analysis.append("值符：").append(zhiFuXing).append("星落").append(zhiFuGongName).append(zhiFuGong).append("宫\n");
        analysis.append("值使：").append(zhiShiMen).append("门落").append(zhiShiGongName).append(zhiShiGong).append("宫\n");

        // 符使关系
        if (zhiFuGong == zhiShiGong) {
            analysis.append("符使同宫，事情容易成功，求事不空。\n");
        } else if (isXiangSheng(zhiFuGong, zhiShiGong)) {
            analysis.append("符使相生，事情往往容易成功。\n");
        } else if (isXiangKe(zhiFuGong, zhiShiGong)) {
            analysis.append("符使相克，事情往往不顺利。\n");
        } else if (isXiangChong(zhiFuGong, zhiShiGong)) {
            analysis.append("符使对冲，两气相悖，事情难成。\n");
        }
        analysis.append("\n");

        // ==================== 4. 空亡分析 ====================
        analysis.append("【空亡分析】\n");
        String kongWang = data.getKongWang();
        if (kongWang != null && !kongWang.isEmpty()) {
            analysis.append("空亡：").append(kongWang).append("\n");
            if (KONG_WANG_JIE_DU.containsKey(kongWang)) {
                analysis.append(KONG_WANG_JIE_DU.get(kongWang)).append("\n");
            }
        } else {
            analysis.append("此局无空亡\n");
        }
        analysis.append("\n");

        // ==================== 5. 马星分析 ====================
        analysis.append("【马星分析】\n");
        int maXingGong = data.getMaXingGong();
        if (maXingGong > 0) {
            String maXingGongName = NUM_TO_GONG_NAME.get(maXingGong);
            analysis.append("马星落").append(maXingGongName).append(maXingGong).append("宫，主动、变动、变化、分离、传递、发展。\n");
            if (MA_XING_JIE_DU.containsKey(maXingGongName)) {
                analysis.append(MA_XING_JIE_DU.get(maXingGongName)).append("\n");
            }
        }
        analysis.append("\n");

        // ==================== 6. 吉格分析 ====================
        List<String> jiGeList = data.getJiGeList();
        if (jiGeList != null && !jiGeList.isEmpty()) {
            analysis.append("【吉格分析】\n");
            for (String jiGe : jiGeList) {
                analysis.append("★ ").append(jiGe).append("\n");
                if (JI_GE.containsKey(jiGe)) {
                    analysis.append("  ").append(JI_GE.get(jiGe)).append("\n");
                }
            }
            analysis.append("\n");
        }

        // ==================== 7. 凶格分析 ====================
        List<String> xiongGeList = data.getXiongGeList();
        if (xiongGeList != null && !xiongGeList.isEmpty()) {
            analysis.append("【凶格分析】\n");
            for (String xiongGe : xiongGeList) {
                analysis.append("★ ").append(xiongGe).append("\n");
                if (XIONG_GE.containsKey(xiongGe)) {
                    analysis.append("  ").append(XIONG_GE.get(xiongGe)).append("\n");
                }
            }
            analysis.append("\n");
        }

        // ==================== 8. 大局分析 ====================
        analysis.append("【大局分析】\n");
        analysis.append("遁法：").append(data.getDun()).append("遁\n");
        analysis.append("局数：").append(data.getJu()).append("局\n");
        analysis.append("节气：").append(data.getJieQi()).append(" ").append(data.getYuan()).append("\n");
        analysis.append("\n");

        // ==================== 9. 日干时干关系 ====================
        analysis.append("【日干时干关系】\n");
        int riGanGong = findGanGong(data, riGan);
        int shiGanGong = findGanGong(data, shiGan);
        if (riGanGong > 0 && shiGanGong > 0) {
            String riGongName = NUM_TO_GONG_NAME.get(riGanGong);
            String shiGongName = NUM_TO_GONG_NAME.get(shiGanGong);
            analysis.append("日干").append(riGan).append("落").append(riGongName).append(riGanGong).append("宫\n");
            analysis.append("时干").append(shiGan).append("落").append(shiGongName).append(shiGanGong).append("宫\n");

            if (riGanGong == shiGanGong) {
                analysis.append("日干时干同宫，事情与求测者密切相关，容易成。\n");
            } else if (isXiangSheng(shiGanGong, riGanGong)) {
                analysis.append("时干生日干，事态主动有利，事情会主动来找你。\n");
            } else if (isXiangSheng(riGanGong, shiGanGong)) {
                analysis.append("日干生时干，求测者主动去促成事情。\n");
            } else if (isXiangKe(shiGanGong, riGanGong)) {
                analysis.append("时干克日干，事情对求测者不利，有压力。\n");
            } else if (isXiangKe(riGanGong, shiGanGong)) {
                analysis.append("日干克时干，求测者能掌控事情。\n");
            }
        }
        analysis.append("\n");

        // ==================== 10. 综合断局 ====================
        interpretation.append("========== 断局内容 ==========\n\n");
        interpretation.append("综合本局干支格局与星门神仪组合，结合国学术数文化解读如下：\n\n");

        // 根据分析结果生成断语
        List<String> interpretations = new ArrayList<>();

        // 整体运势判断
        if (xiongGeList != null && xiongGeList.contains("伏吟")) {
            interpretations.add("1. 整体运势：局呈伏吟之象，主静守为宜，求财不利，宜收敛财货，不宜主动出击。凡事多阻滞，宜耐心等待时机。");
        } else if (xiongGeList != null && xiongGeList.contains("反吟")) {
            interpretations.add("1. 整体运势：局呈反吟之象，主变动快速，宜主动出击，但需防半途而废。求财易有反复，近病易愈，远病难愈。");
        } else if (xiongGeList != null && xiongGeList.contains("天网四张")) {
            interpretations.add("1. 整体运势：天网四张之局，百事皆凶，不宜举事。此时宜静不宜动，等待时机。");
        } else {
            interpretations.add("1. 整体运势：局象平稳，动静相宜，可顺势而为，静待时机成熟。");
        }

        // 判断是否有重要凶格
        if (xiongGeList != null) {
            if (xiongGeList.contains("青龙逃走")) {
                interpretations.add("2. 重要警示：青龙逃走之格，主客皆伤，百事不利，远行多殃，需防财物损失。");
            } else if (xiongGeList.contains("白虎猖狂")) {
                interpretations.add("2. 重要警示：白虎猖狂之格，人亡家败，百事凶，需防意外伤灾。");
            } else if (xiongGeList.contains("朱雀投江")) {
                interpretations.add("2. 重要警示：朱雀投江之格，文书口舌俱消，音信沉溺，需防文书失误。");
            } else if (xiongGeList.contains("腾蛇夭矫")) {
                interpretations.add("2. 重要警示：腾蛇夭矫之格，官非口舌，百事皆凶，需防官司诉讼。");
            } else if (xiongGeList.contains("太白入荧")) {
                interpretations.add("2. 重要警示：太白入荧之格，贼必来，为客进利，为主破财，需防盗窃。");
            } else if (xiongGeList.contains("荧入太白")) {
                interpretations.add("2. 重要警示：荧入太白之格，门户破败，盗贼耗失，需防火灾。");
            } else if (xiongGeList.contains("大格")) {
                interpretations.add("2. 重要警示：大格之象，图谋未遂，求人不见，需防计划落空。");
            } else if (xiongGeList.contains("小格")) {
                interpretations.add("2. 重要警示：小格之象，遇事多有变动，不宜出师远行。");
            } else if (xiongGeList.contains("刑格")) {
                interpretations.add("2. 重要警示：刑格之象，官司被重刑，先动者不利。");
            } else if (xiongGeList.contains("门迫")) {
                interpretations.add("2. 重要警示：门迫之象，吉门被迫吉不成，凶门被迫祸重重。");
            }
        }

        // 判断是否有重要吉格
        if (jiGeList != null) {
            if (jiGeList.contains("青龙返首")) {
                interpretations.add("3. 重要吉兆：青龙返首之格，百事大吉，动作大吉，可大胆行事。");
            } else if (jiGeList.contains("飞鸟跌穴")) {
                interpretations.add("3. 重要吉兆：飞鸟跌穴之格，百事大吉，谋为顺遂。");
            } else if (jiGeList.contains("天遁")) {
                interpretations.add("3. 重要吉兆：天遁之格，百事生旺，宜行兵、献策、摄王侯之权。");
            } else if (jiGeList.contains("地遁")) {
                interpretations.add("3. 重要吉兆：地遁之格，宜安葬、埋伏、出门、造屋一切皆吉。");
            } else if (jiGeList.contains("人遁")) {
                interpretations.add("3. 重要吉兆：人遁之格，宜密探、隐迹、谒贵、招贤、求亲、经营。");
            }
        }

        // 根据日干时干关系
        if (riGanGong > 0 && shiGanGong > 0) {
            if (isXiangSheng(shiGanGong, riGanGong)) {
                interpretations.add("4. 事态发展：时干生日干，事态主动有利，事情会主动来找你，宜顺势而为。");
            } else if (riGanGong == shiGanGong) {
                interpretations.add("4. 事态发展：日干时干同宫，事情与求测者密切相关，容易成。");
            }
        }

        // 根据空亡
        if (kongWang != null && !kongWang.isEmpty()) {
            interpretations.add("5. 空亡提醒：局逢空亡，主事暂不成，需待填实或冲实之日。求事不宜急躁。");
        }

        // 根据马星
        if (maXingGong > 0) {
            interpretations.add("6. 变动提示：马星临宫，主变动、出行、调动。近期宜动不宜静。");
        }

        // 根据值符值使关系
        if (zhiFuGong == zhiShiGong) {
            interpretations.add("7. 符使关系：符使同宫，事情容易成功，求事不空。");
        } else if (isXiangSheng(zhiFuGong, zhiShiGong)) {
            interpretations.add("7. 符使关系：符使相生，事情往往容易成功。");
        } else if (isXiangKe(zhiFuGong, zhiShiGong)) {
            interpretations.add("7. 符使关系：符使相克，事情往往不顺利，需多做准备。");
        }

        // 根据庚的位置（对手）
        int gongGong = findGanGong(data, "庚");
        if (gongGong > 0) {
            String gongName = NUM_TO_GONG_NAME.get(gongGong);
            interpretations.add("8. 对手分析：庚落" + gongName + "宫，对手/阻碍/仇人所在。");
            if (isRuMu("庚", gongGong)) {
                interpretations.add("   庚入墓绝之地，对手处于弱势，有利我方。");
            } else if (isXiangKe(gongGong, riGanGong)) {
                interpretations.add("   庚克日干，对手强势，需谨慎应对。");
            } else if (isXiangSheng(riGanGong, gongGong)) {
                interpretations.add("   日干生庚，对对手过于宽容，需防其反噬。");
            }
        }

        // 根据辛的位置（错误、罪人）
        int xinGong = findGanGong(data, "辛");
        if (xinGong > 0 && isRuMu("辛", xinGong)) {
            interpretations.add("9. 错误防范：辛入墓库，错误暂时被掩盖，但需防问题爆发。做事需谨慎细致。");
        }

        // 根据戊的位置（资本、钱财）
        int wuGong = findGanGong(data, "戊");
        if (wuGong > 0 && isRuMu("戊", wuGong)) {
            interpretations.add("10. 财运警示：戊落墓绝之地，资金易被困或受损，投资需谨慎，避免高风险项目。");
        }

        // 添加定日信息（根据节气判断）
        String jieQi = data.getJieQi();
        if (jieQi != null && jieQi.contains("惊蛰")) {
            interpretations.add("\n今日为惊蛰节气，万物复苏，生机勃发。宜顺应天时，积极进取，但需防急躁冒进。");
        }

        // 如果没有匹配到任何预设的断语，给一个默认的
        if (interpretations.size() <= 1) {
            interpretations.add("当前格局信息较少，宜静守待时。");
        }

        // 将所有断语拼接起来
        for (String item : interpretations) {
            interpretation.append(item).append("\n");
        }

        // 添加免责声明
        interpretation.append("\n").append("=".repeat(60)).append("\n");
        interpretation.append("本软件为奇门遁甲数术研究的数字化辅助工具，所有排盘结果均基于传统术数逻辑与数理模型生成，仅供国学文化研究、学术探讨及个人娱乐参考，不等于专业测评，不代表任何价值评判，无任何现实指导意义。");

        // 将分析结果存入data对象
        data.setAnalysisResult(analysis.toString());
        data.setInterpretationResult(interpretation.toString());
        data.setGongAnalysis(gongAnalysis);

        return data;
    }

    /**
     * 判断是否入墓
     */
    private static boolean isRuMu(String gan, int gong) {
        if (gan == null) return false;
        switch (gan) {
            case "乙": return gong == 2; // 乙墓在坤(2)
            case "丙": return gong == 6; // 丙墓在乾(6)
            case "丁": return gong == 8; // 丁墓在艮(8)
            case "戊": return gong == 6; // 戊墓在乾(6)
            case "己": return gong == 2; // 己墓在坤(2)
            case "庚": return gong == 8; // 庚墓在艮(8)
            case "辛": return gong == 4; // 辛墓在巽(4)
            case "壬": return gong == 4; // 壬墓在巽(4)
            case "癸": return gong == 2; // 癸墓在坤(2)
            default: return false;
        }
    }

    /**
     * 获取击刑key
     */
    private static String getJiXingKey(String gan, int gong) {
        if (gan == null) return null;
        switch (gan) {
            case "戊": if (gong == 3) return "甲子戊震";
            case "己": if (gong == 2) return "甲戌己坤";
            case "庚": if (gong == 8) return "甲申庚艮";
            case "辛": if (gong == 9) return "甲午辛离";
            case "壬": if (gong == 4) return "甲辰壬巽";
            case "癸": if (gong == 4) return "甲寅癸巽";
            default: return null;
        }
    }

    /**
     * 查找天干所在宫位
     */
    private static int findGanGong(QiMenData data, String gan) {
        if (data == null || gan == null || gan.isEmpty()) {
            return -1;
        }
        for (int gong = 1; gong <= 9; gong++) {
            String tianGan = data.getTianPanJiuGan().get(gong);
            if (gan.equals(tianGan)) {
                return gong;
            }
        }
        return -1;
    }

    /**
     * 判断是否相生
     */
    private static boolean isXiangSheng(int gong1, int gong2) {
        // 参数有效性检查
        if (gong1 <= 0 || gong1 > 9 || gong2 <= 0 || gong2 > 9) {
            return false;
        }
        String wuXing1 = GONG_WU_XING.get(gong1);
        String wuXing2 = GONG_WU_XING.get(gong2);
        if (wuXing1 == null || wuXing2 == null) {
            return false;
        }
        return (wuXing1.equals("木") && wuXing2.equals("火")) ||
                (wuXing1.equals("火") && wuXing2.equals("土")) ||
                (wuXing1.equals("土") && wuXing2.equals("金")) ||
                (wuXing1.equals("金") && wuXing2.equals("水")) ||
                (wuXing1.equals("水") && wuXing2.equals("木"));
    }

    /**
     * 判断是否相克
     */
    private static boolean isXiangKe(int gong1, int gong2) {
        // 参数有效性检查
        if (gong1 <= 0 || gong1 > 9 || gong2 <= 0 || gong2 > 9) {
            return false;
        }
        String wuXing1 = GONG_WU_XING.get(gong1);
        String wuXing2 = GONG_WU_XING.get(gong2);
        if (wuXing1 == null || wuXing2 == null) {
            return false;
        }
        return (wuXing1.equals("木") && wuXing2.equals("土")) ||
                (wuXing1.equals("土") && wuXing2.equals("水")) ||
                (wuXing1.equals("水") && wuXing2.equals("火")) ||
                (wuXing1.equals("火") && wuXing2.equals("金")) ||
                (wuXing1.equals("金") && wuXing2.equals("木"));
    }

    /**
     * 判断是否对冲
     */
    private static boolean isXiangChong(int gong1, int gong2) {
        // 参数有效性检查
        if (gong1 <= 0 || gong1 > 9 || gong2 <= 0 || gong2 > 9) {
            return false;
        }
        return (gong1 == 1 && gong2 == 9) || (gong1 == 9 && gong2 == 1) ||
                (gong1 == 2 && gong2 == 8) || (gong1 == 8 && gong2 == 2) ||
                (gong1 == 3 && gong2 == 7) || (gong1 == 7 && gong2 == 3) ||
                (gong1 == 4 && gong2 == 6) || (gong1 == 6 && gong2 == 4);
    }
}