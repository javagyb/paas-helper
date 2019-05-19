package net.winroad.wrdoclet.data;

import java.util.LinkedList;
import java.util.List;

public class ModificationHistory {
	public ModificationHistory() {
		this.modificationRecordList = new LinkedList<ModificationRecord>();
	}

	public ModificationHistory(LinkedList<ModificationRecord> modificationRecordList) {
		this.modificationRecordList = modificationRecordList;
	}

	private LinkedList<ModificationRecord> modificationRecordList;

	public LinkedList<ModificationRecord> getModificationRecordList() {
		return modificationRecordList;
	}

	public void addModificationRecord(ModificationRecord record) {
		this.modificationRecordList.add(record);
	}

	public void addModificationRecords(LinkedList<ModificationRecord> record) {
		this.modificationRecordList.addAll(record);
	}

	/*
	 * @return Whether history contains modification on specified version. If no
	 * version specified, returns true.
	 */
	public boolean isModifiedOnVersion(String version) {
		if (version == null || version.isEmpty()) {
			return true;
		}
		for (ModificationRecord record : this.modificationRecordList) {
			if (record.isModifiedOnVersion(version)) {
				return true;
			}
		}
		return false;
	}
}