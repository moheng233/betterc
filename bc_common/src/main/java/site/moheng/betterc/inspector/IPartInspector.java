package site.moheng.betterc.inspector;

import site.moheng.betterc.antlr.BCListener;

public interface IPartInspector extends BCListener {
    InspectorContext getContext();
}
