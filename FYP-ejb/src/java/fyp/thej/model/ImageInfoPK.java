/*
 * Final Year Project(EasyContact)
 */

package fyp.thej.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * ImageInfoPK
 * Apr 9, 2013 2:48:49 AM
 * Thejanee Walgamage <2008061>
 */
@Embeddable
public class ImageInfoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "image_id")
    private int imageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    public ImageInfoPK() {
    }

    public ImageInfoPK(int imageId, int userId) {
        this.imageId = imageId;
        this.userId = userId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) imageId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageInfoPK)) {
            return false;
        }
        ImageInfoPK other = (ImageInfoPK) object;
        if (this.imageId != other.imageId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fyp.thej.model.ImageInfoPK[ imageId=" + imageId + ", userId=" + userId + " ]";
    }

}
