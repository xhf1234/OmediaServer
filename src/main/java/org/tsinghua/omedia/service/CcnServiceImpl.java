package org.tsinghua.omedia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tsinghua.omedia.dao.AccountDao;
import org.tsinghua.omedia.dao.CcnDao;
import org.tsinghua.omedia.model.CcnFile;

@Component("ccnService")
public class CcnServiceImpl extends BaseService implements CcnService {
    @Autowired
    private CcnDao ccnDao;
    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveCcnFile(CcnFile ccnFile)
            throws IOException {
        ccnDao.saveCcnFile(ccnFile);
        if(ccnFile.getType() == CcnFile.TYPE_PRIVATE) {
            accountDao.updateCcnFileVersion(ccnFile.getAccountId(), System.currentTimeMillis());
        } else {
            accountDao.updateCcnFileVersion(System.currentTimeMillis());
        }
    }

    @Override
    public List<CcnFile> listCcnFiles(long accountId) throws IOException {
        return ccnDao.listAllCcnFiles(accountId);
    }

    @Override
    public void dumpCcnFileToRepo() throws IOException {
        List<CcnFile> ccnFiles = ccnDao.listAllCcnFiles();
        for(CcnFile e:ccnFiles) {
            ccnUtils.ccnPutFile(e);
        }
    }
}
