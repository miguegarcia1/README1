package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FilmEntity(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "Director")val Director: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "rating")val rating: Double,
    @ColumnInfo(name = "imageUrl")val imageUrl: String,
    @ColumnInfo(name = "VideoId")val VideoId: String?





)



