// 코드 6-1 GORM Book 엔티티

package readinglist

import grails.persistence.Entity

@Entity    // GORM 엔티티
class Book {
    Reader reader
    String isbn
    String title
    String author
    String description
}
