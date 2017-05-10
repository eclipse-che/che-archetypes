package ${package}.ide.view.client.jso;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

/**
 * Utility providing functions to operate with frames.
 */
public class FrameOverlay {

    private JavaScriptObject frame;

    public FrameOverlay(JavaScriptObject frame) {
        this.frame = frame;
    }

    /**
     * Returns frame window element
     *
     * @return frame window element
     */
    public native JavaScriptObject getFrameWindow() /*-{
        var f = this.@${package}.ide.view.client.jso.FrameOverlay::frame;
        return f.contentWindow;
    }-*/;

    /**
     * Returns frame body element.
     *
     * @return frame body element
     */
    public native JavaScriptObject getBodyElement() /*-{
        var frame = this.@${package}.ide.view.client.jso.FrameOverlay::frame;
        var doc = frame.contentDocument || frame.contentWindow.document;
        return doc.body;
    }-*/;

    /**
     * Injects an external JavaScript reference into frame document
     *
     * @param scriptUrl url to the script
     * @param callback callback to be invoked when the loading is finished
     */
    public void injectScript(String scriptUrl, Callback<Void, Exception> callback) {
        ScriptInjector.fromUrl(scriptUrl).setWindow(getFrameWindow()).setCallback(callback).inject();
    };

    /**
     * Injects an external JavaScript reference into frame document
     *
     * @param scripts array of urls to the scripts
     * @param callback callback to be invoked when the loading is finished
     */
    public void injectScripts(String[] scripts, Callback<Void, Exception> callback) {
        injectScripts(scripts, 0, callback);
    };

    private void injectScripts(final String[] scripts, final int index, final Callback<Void, Exception> callback) {
        if (index == scripts.length) {
            callback.onSuccess(null);
            return;
        }

        ScriptInjector.fromUrl(scripts[index]).setWindow(getFrameWindow()).setCallback(new Callback<Void, Exception>() {
            @Override
            public void onFailure(Exception reason) {
                callback.onFailure(reason);
            }

            @Override
            public void onSuccess(Void result) {
                injectScripts(scripts, index + 1, callback);
            }
        }).inject();
    }

    /**
     * Injects an external StyleSheet reference into frame document
     *
     * @param styleUrl url to the stylesheet
     */
    public native void injectStyle(String styleUrl) /*-{
        var frame = this.@${package}.ide.view.client.jso.FrameOverlay::frame;
        var doc = frame.contentDocument || frame.contentWindow.document;

        var link = doc.createElement("link");
        link.setAttribute("rel", "stylesheet");
        link.setAttribute("type", "text/css");
        link.setAttribute("href", styleUrl);
        doc.head.appendChild(link);
    }-*/;

    /**
     * Sets new content for the frame document
     *
     * @param content new frame content
     */
    public native void setContent(String content) /*-{
        var frame = this.@${package}.ide.view.client.jso.FrameOverlay::frame;
        var doc = frame.contentDocument || frame.contentWindow.document;
        doc.write(content);
    }-*/;

    /**
     * Runs java script code inside frame.
     *
     * @param javaScript java script to be executed
     */
    public native void runJavaScript(String javaScript) /*-{
        var w = this.@${package}.ide.view.client.jso.FrameOverlay::getFrameWindow()();
        w.eval(javaScript);
    }-*/;

}
