package com.example.thooughtctl_app.RequestResponse

import com.fasterxml.jackson.annotation.JsonProperty

/*
data class ImgurResponse(
    val data: List<ImageData>,
    val success: Boolean,
    val status: Int
)
data class ImageData(
    val id: String,
    val title: String,
    val link: String
)*/



data class ImgurResponse(
    val data: List<Daum>,
    val success: Boolean,
    val status: Long,
)

data class Daum(
    val id: String,
    val title: String,
    val description: Any?,
    val datetime: Long,
    val cover: String?,
    val cover_width: Long?,
    val cover_height: Long?,
    val account_url: String,
    val account_id: Long,
    val privacy: String?,
    val layout: String?,
    val views: Long,
    val link: String,
    val ups: Long,
    val downs: Long,
    val points: Long,
    val score: Long,
    val is_album: Boolean,
    val vote: Any?,
    val favorite: Boolean,
    val nsfw: Boolean,
    val section: String,
    val comment_count: Long,
    val favorite_count: Long,
    val topic: Any?,
    val topic_id: Long?,
    val images_count: Long?,
    val in_gallery: Boolean,
    val is_ad: Boolean,
    val tags: List<Tag>,
    val ad_type: Long,
    val ad_url: String,
    val in_most_viral: Boolean,
    val include_album_ads: Boolean?,
    val images: List<Image>?,
    val ad_config: AdConfig,
    val type: String?,
    val animated: Boolean?,
    val width: Long?,
    val height: Long?,
    val size: Long?,
    val bandwidth: Long?,
    val has_sound: Boolean?,
    val edited: Long?,
    val mp4_size: Long?,
    val mp4: String?,
    val gifv: String?,
    val hls: String?,
    val processing: Processing2?,
)

data class Tag(
    val name: String,
    @JsonProperty("display_name")
    val displayName: String,
    val followers: Long,
    @JsonProperty("total_items")
    val totalItems: Long,
    val following: Boolean,
    @JsonProperty("is_whitelisted")
    val isWhitelisted: Boolean,
    @JsonProperty("background_hash")
    val backgroundHash: String,
    @JsonProperty("thumbnail_hash")
    val thumbnailHash: String?,
    val accent: String?,
    @JsonProperty("background_is_animated")
    val backgroundIsAnimated: Boolean,
    @JsonProperty("thumbnail_is_animated")
    val thumbnailIsAnimated: Boolean,
    @JsonProperty("is_promoted")
    val isPromoted: Boolean,
    val description: String,
    @JsonProperty("logo_hash")
    val logoHash: Any?,
    @JsonProperty("logo_destination_url")
    val logoDestinationUrl: Any?,
    @JsonProperty("description_annotations")
    val descriptionAnnotations: Map<String, Any>,
)

data class Image(
    val id: String,
    val title: Any?,
    val description: String?,
    val datetime: Long,
    val type: String,
    val animated: Boolean,
    val width: Long,
    val height: Long,
    val size: Long,
    val views: Long,
    val bandwidth: Long,
    val vote: Any?,
    val favorite: Boolean,
    val nsfw: Any?,
    val section: Any?,
    @JsonProperty("account_url")
    val accountUrl: Any?,
    @JsonProperty("account_id")
    val accountId: Any?,
    @JsonProperty("is_ad")
    val isAd: Boolean,
    @JsonProperty("in_most_viral")
    val inMostViral: Boolean,
    @JsonProperty("has_sound")
    val hasSound: Boolean,
    val tags: List<Any?>,
    @JsonProperty("ad_type")
    val adType: Long,
    @JsonProperty("ad_url")
    val adUrl: String,
    val edited: String,
    @JsonProperty("in_gallery")
    val inGallery: Boolean,
    val link: String,
    @JsonProperty("mp4_size")
    val mp4Size: Long?,
    val mp4: String?,
    val gifv: String?,
    val hls: String?,
    val processing: Processing?,
    @JsonProperty("comment_count")
    val commentCount: Any?,
    @JsonProperty("favorite_count")
    val favoriteCount: Any?,
    val ups: Any?,
    val downs: Any?,
    val points: Any?,
    val score: Any?,
    val looping: Boolean?,
)

data class Processing(
    val status: String,
)

data class AdConfig(
    val safeFlags: List<String>,
    val highRiskFlags: List<Any?>,
    val unsafeFlags: List<String>,
    val wallUnsafeFlags: List<String>,
    val showsAds: Boolean,
    val showAdLevel: Long,
    @JsonProperty("safe_flags")
    val safeFlags2: List<String>,
    @JsonProperty("high_risk_flags")
    val highRiskFlags2: List<Any?>,
    @JsonProperty("unsafe_flags")
    val unsafeFlags2: List<String>,
    @JsonProperty("wall_unsafe_flags")
    val wallUnsafeFlags2: List<String>,
    @JsonProperty("show_ads")
    val showAds: Boolean,
    @JsonProperty("show_ad_level")
    val showAdLevel2: Long,
    @JsonProperty("nsfw_score")
    val nsfwScore: Double,
)

data class Processing2(
    val status: String,
)
