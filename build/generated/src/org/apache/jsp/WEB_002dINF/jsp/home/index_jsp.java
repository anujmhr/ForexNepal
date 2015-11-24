package org.apache.jsp.WEB_002dINF.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${SITE_URL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/assets/js/d3/d3.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            div.bar {\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 20px;\n");
      out.write("                height: 75px;  \n");
      out.write("                margin-right: 2px;\n");
      out.write("                background-color: teal;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("//            var dataset = [\n");
      out.write("//                {\n");
      out.write("//                    \"x_axis\": 30,\n");
      out.write("//                    \"y_axis\": 30,\n");
      out.write("//                    \"radius\": 20,\n");
      out.write("//                    \"color\": \"green\"\n");
      out.write("//                }, {\n");
      out.write("//                    \"x_axis\": 70,\n");
      out.write("//                    \"y_axis\": 70,\n");
      out.write("//                    \"radius\": 20,\n");
      out.write("//                    \"color\": \"purple\"\n");
      out.write("//                }, {\n");
      out.write("//                    \"x_axis\": 110,\n");
      out.write("//                    \"y_axis\": 100,\n");
      out.write("//                    \"radius\": 20,\n");
      out.write("//                    \"color\": \"red\"\n");
      out.write("//                }];\n");
      out.write("//\n");
      out.write("//\n");
      out.write("//\n");
      out.write("//            console.log(dataset);\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            d3.json(\"ForexNepal/exchange_rates/bank/6\", function (error, data) {\n");
      out.write("                if (error)\n");
      out.write("                    return console.log(error);\n");
      out.write("\n");
      out.write("                console.log(data);\n");
      out.write("                var arr = Object.keys(data).map(function (k) {\n");
      out.write("                    return data[k]\n");
      out.write("                });\n");
      out.write("                console.log(arr);\n");
      out.write("                var svg = d3.select(\"body\").selectAll(\"div\")\n");
      out.write("                        .data(arr, function (d) {\n");
      out.write("                            return d\n");
      out.write("                        })\n");
      out.write("                        .enter()\n");
      out.write("                        .append(\"div\")\n");
      out.write("                        .attr(\"width\", 700)\n");
      out.write("                        .attr(\"height\", 700)\n");
      out.write("                        .attr(\"class\", \"bar\")\n");
      out.write("                        .style(\"height\", function (d) {\n");
      out.write("                            var barHeight = d;\n");
      out.write("                            return barHeight + \"px\";\n");
      out.write("                        })\n");
      out.write("\n");
      out.write("            });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("//            var dataset = [5, 10, 13, 19, 21, 25, 22, 18, 15, 13,\n");
      out.write("//                11, 12, 15, 20, 18, 17, 16, 18, 23, 25];\n");
      out.write("//\n");
      out.write("\n");
      out.write("// var svg = d3.select(\"body\").append(\"svg\")\n");
      out.write("//                        .attr(\"width\", 200)\n");
      out.write("//                        .attr(\"height\", 200)\n");
      out.write("//                        .attr(\"class\", \"bar\")\n");
      out.write("//                        .style(\"height\", function (d) {\n");
      out.write("//                            var barHeight =d.buyingRate * 5;\n");
      out.write("//                            return barHeight + \"px\";\n");
      out.write("//                        })\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            //            var dataset = [25, 7, 5, 26, 11, 8, 25, 14, 23, 19,\n");
      out.write("            //                14, 11, 22, 29, 11, 13, 12, 17, 18, 10,\n");
      out.write("            //                24, 18, 25, 9, 3];\n");
      out.write("\n");
      out.write("//    var dataset = [];                        //Initialize empty array\n");
      out.write("//             for (var i = 0; i < 25; i++) {           //Loop 25 times\n");
      out.write("//             var newNumber = Math.random() * 30;  //New random number (0-30)\n");
      out.write("//             dataset.push(newNumber);             //Add new number to array\n");
      out.write("//             }\n");
      out.write("//             \n");
      out.write("//             d3.select(\"body\").selectAll(\"div\")\n");
      out.write("//             .data(dataset)  // <-- The answer is here!\n");
      out.write("//             .enter()\n");
      out.write("//             .append(\"div\")\n");
      out.write("//             .attr(\"class\", \"bar\")\n");
      out.write("//             .style(\"height\", function (d) {\n");
      out.write("//             var barHeight = d * 5;\n");
      out.write("//             return barHeight + \"px\";\n");
      out.write("//             });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("SITE_URL");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
