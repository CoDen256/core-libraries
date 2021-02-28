package coden.reverso.client.queryservice.context.request;

import coden.reverso.language.ReversoLanguage;

public class ReversoContextRequestMapper {
    public ReversoContextRequest map(ReversoLanguage source, ReversoLanguage target, String phrase) {
        ReversoContextRequest request = new ReversoContextRequest();
        request.setMode(0);
        request.setNPage(1);
        request.setSourceLang(source.getQueryServiceStandard());
        request.setTargetLang(target.getQueryServiceStandard());
        request.setSourceText(phrase);
        request.setTargetText("");
        return request;
    }
}
