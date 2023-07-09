package com.github.otr.academy_backend.infrastructure.database.dbo

/**
 *
 */
//@Entity
//class PostModel(text: String, postedBy: Profile): Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = 0
//
//    var text: String? = text
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="profile_id")
//    @JsonIgnoreProperties(
//        "username","password", "email", "accCreatedTime", "firstName", "lastName",
//        "contactNumber", "dob", "city", "country"
//    )
//    var postedBy: Profile? = postedBy
//
//    @JsonIgnore
//    @JsonProperty("postCreatedTime")
//    var postCreatedTime: Instant? = Instant.now()
//
//    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
//    val comments = mutableListOf<Comment>()
//
//    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
//    var likes: List<LikeObj>? = mutableListOf<LikeObj>()
//
//}
