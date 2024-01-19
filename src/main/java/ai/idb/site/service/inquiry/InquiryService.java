package ai.idb.site.service.inquiry;

public interface InquiryService {
    // userlist에게 문의 보냄 이때 문의는 user의 이메일로 보내고 해당 inquiry는 db에 저장
    // 문의는 제한을 걸어야함 안그럼 서버 터짐 - 가격도 많이 나올것(이메일 보냄 서비스)
    // 슬랙이랑도 연동 시켜야 겠다. 누구누구에게 문의 이메일이 공식홈페이지로 부터 왔다고하면 좋을듯
    // 그리고 문의가 왔으면 pushing 서비스가 웹페이지 내에서 보여야함

    public void sendEmail();










}
