// 코드 3-8 독자를 나타내는 타입을 Reader로 변경한 Book 엔티티

...
public class Book {
    ...
    private Reader reader;
    ...
    public Reader getREader() {
	return reader;
    }

    public void setReader(Reader reader) {
	this.reader = reader;
    }
    ...
}
