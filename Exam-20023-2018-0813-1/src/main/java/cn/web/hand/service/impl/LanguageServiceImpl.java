package cn.web.hand.service.impl;

import java.util.List;

import cn.web.hand.dao.ILanguageDao;
import cn.web.hand.dao.impl.LanguageDaoImpl;
import cn.web.hand.entity.Language;
import cn.web.hand.service.ILanguageService;

public class LanguageServiceImpl implements ILanguageService {

	public List<Language> showLanguages() {
		ILanguageDao ld = new LanguageDaoImpl();
		List<Language> languages = ld.showLanguages();
		return languages;
	}

}
