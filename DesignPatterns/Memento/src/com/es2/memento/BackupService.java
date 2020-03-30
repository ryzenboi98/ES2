package com.es2.memento;
import java.util.ArrayList;

public class BackupService extends Object{
    ArrayList<Memento> snapshots = new ArrayList<Memento>();
    Server server;

    public BackupService(Server server) {
        this.server = server;
    }

    public void takeSnapshot() {
        snapshots.add(server.backup());
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
    if (snapshotNumber >= snapshots.size() || snapshotNumber < 0)
            throw new NotExistingSnapshotException();
    else
        this.server.restore(snapshots.get(snapshotNumber));
    }
}

