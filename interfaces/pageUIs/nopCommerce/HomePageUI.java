package pageUIs.nopCommerce;

public class HomePageUI {

    /*
    * 1. public: bat' ki` class nao` cung goi den' de su dung duoc
    *           - ko xai protected vi` cac' class ben ngoai` ko dung` dc -> ko ap dung ke thua`
    *           - ko set private vi` ngoai` class ko dung` dc
    *           - ko set default vi` ngoai` packed ko dung` dc
    *           - se~ co ng dung' tu` ...PageObject khac' goi qua HomePageUI -> sai business
    *           - communication/ convention: PageObject nao` thi` goi qua UI do'
    *
    * 2. static: truy cap thang? tu` pham vi class khac qua ma` ko can khoi tao
    *
    * 3. final: ko dc phep' thay doi gia tri cua bien khi su dung - ko nen thay doi trong qua trinh` chay.
    *           - ko co' tu` khoa' nao` dai dien cho hang` so'
    *           - static + final = hang` so'
    *
    *4. - xpath/ css/ id/ class/ name: tham so cua class By
    *
    * 5. Te^n bien' = ten element + loai. element
    *
    * 6. tranh' viec lap lai - define 1 lan`
    * 7. ko quan tam man` hinh` khac cung co' elemnet do'
    * */

    // field/ bien'
    public static final String ABOUT_US_LINK = "//div[@class='sui-display-none___JJyjC sui-display-md-block___bfij1 sui-col___xXTZD sui-col-12___cgLQS sui-col-sm-12___AJXmh sui-col-md-3___fj0of sui-col-responsive___1C9c8']//nav[@aria-label='Company']//a[text()='About Us']";
    public static final String SEARCH_BY_LINK = "//div[@class='sui-search-input__children___HmvCs']/a";
    public static final String AUDI_LINK = "";
    public static final String AMG_LINK = "";
    public static final String theUltimate = "//h1[@class='VideoHero_title__JqDaX']";


}
