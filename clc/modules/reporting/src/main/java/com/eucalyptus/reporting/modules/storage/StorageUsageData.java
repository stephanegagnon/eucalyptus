/*************************************************************************
 * Copyright 2009-2012 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/

package com.eucalyptus.reporting.modules.storage;

import javax.persistence.*;

@Embeddable
public class StorageUsageData
{
	@Column(name="volumes_num", nullable=false)
	protected Long volumesNum;
	@Column(name="volumes_megs", nullable=false)
	protected Long volumesMegs;
	@Column(name="snapshot_num", nullable=false)
	protected Long snapshotsNum;
	@Column(name="snapshot_megs", nullable=false)
	protected Long snapshotsMegs;
	
	public StorageUsageData()
	{
		this.volumesNum     = new Long(0);
		this.volumesMegs    = new Long(0);
		this.snapshotsNum   = new Long(0);
		this.snapshotsMegs  = new Long(0);
	}

	public StorageUsageData(Long volumesNum, Long volumesMegs, Long snapshotsNum,
			Long snapshotsMegs)
	{
		if (volumesNum == null || volumesMegs == null || snapshotsNum == null
				|| snapshotsMegs == null)
		{
			throw new IllegalArgumentException("args can't be null");
		}
		this.volumesNum     = volumesNum;
		this.volumesMegs    = volumesMegs;
		this.snapshotsNum   = snapshotsNum;
		this.snapshotsMegs  = snapshotsMegs;
	}

	public Long getVolumesNum()
	{
		return volumesNum;
	}
	
	public Long getVolumesMegs()
	{
		return volumesMegs;
	}
	
	public Long getSnapshotsNum()
	{
		return snapshotsNum;
	}
	
	public Long getSnapshotsMegs()
	{
		return snapshotsMegs;
	}
	
	public void setVolumesNum(Long volumesNum)
	{
		if (volumesNum==null) throw new IllegalArgumentException("arg can't be null");
		this.volumesNum = volumesNum;
	}

	public void setVolumesMegs(Long volumesMegs)
	{
		if (volumesMegs==null) throw new IllegalArgumentException("arg can't be null");
		this.volumesMegs = volumesMegs;
	}

	public void setSnapshotsNum(Long snapshotsNum)
	{
		if (snapshotsNum==null) throw new IllegalArgumentException("arg can't be null");
		this.snapshotsNum = snapshotsNum;
	}

	public void setSnapshotsMegs(Long snapshotsMegs)
	{
		if (snapshotsMegs==null) throw new IllegalArgumentException("arg can't be null");
		this.snapshotsMegs = snapshotsMegs;
	}

	private static Long sumLongs(Long a, Long b)
	{
		return new Long(a.longValue() + b.longValue());
	}

	public StorageUsageData sumFrom(StorageUsageData other)
	{
		if (other == null) return null;
		return new StorageUsageData(
				sumLongs(this.volumesNum, other.volumesNum),
				sumLongs(this.volumesMegs, other.volumesMegs),
				sumLongs(this.snapshotsNum, other.snapshotsNum),
				sumLongs(this.snapshotsMegs, other.snapshotsMegs)
				);
	}

	public String toString()
	{
		return String.format("[vols:%d,volsMegs:%d,snaps:%d,snapsMegs:%d]",
				volumesNum, volumesMegs, snapshotsNum,
				snapshotsMegs);
	}


}
