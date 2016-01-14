import java.net.MalformedURLException;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;

public class ReasonJena {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		Model mod = ModelFactory.createDefaultModel();
		mod.read("file:/home/datametica/Downloads/eclipse/u/RDFReson/src/testdata.txt", "N3");
		Reasoner reasoner = new GenericRuleReasoner(
				Rule.rulesFromURL("/home/datametica/Downloads/eclipse/u/RDFReson/src/rules.txt"));

		InfModel inf = ModelFactory.createInfModel(reasoner, mod);

		StmtIterator iter = inf.listStatements();
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement();
			//System.out.println(stmt);
			Resource sub = stmt.getSubject();
			//System.out.println(sub);
			Property pre = stmt.getPredicate();
			//System.out.println(pre);
			RDFNode obj = stmt.getObject();
			//System.out.println(obj);

			System.out.print(sub.toString());
			System.out.print(" " + pre.toString() + " ");
			if (obj instanceof Resource) {
				System.out.print(obj.toString());
			} else {

				System.out.print(" \"" + obj.toString() + "\"");
			}
			System.out.println(" .");
		}
	}
}
