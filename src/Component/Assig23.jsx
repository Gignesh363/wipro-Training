import React from "react";
import { Formik, Form, Field, FieldArray, ErrorMessage } from "formik";
import * as Yup from "yup";
import "bootstrap/dist/css/bootstrap.min.css";

const HockeyTournamentForm = () => {
  const initialValues = {
    playerName: "",
    age: "",
    position: "",
    teamName: "",
    captain: false,
    skills: [""],
    pastTeams: [{ clubName: "", years: "" }],
  };

  const validationSchema = Yup.object({
    playerName: Yup.string().required("Player Name is required"),
    age: Yup.number()
      .required("Age is required")
      .positive("Age must be positive")
      .integer("Age must be an integer"),
    position: Yup.string().required("Position is required"),
    teamName: Yup.string().required("Team Name is required"),
    skills: Yup.array().of(Yup.string().required("Skill cannot be empty")),
    pastTeams: Yup.array().of(
      Yup.object({
        clubName: Yup.string().required("Club Name is required"),
        years: Yup.number()
          .required("Years is required")
          .positive("Years must be positive")
          .integer("Years must be an integer"),
      })
    ),
  });

  const onSubmit = (values, { resetForm }) => {
    alert(JSON.stringify(values, null, 2));
    resetForm();
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Hockey Tournament Registration</h2>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
      >
        {({ values }) => (
          <Form>
            {/* Player Name */}
            <div className="mb-3">
              <label className="form-label">Player Name</label>
              <Field name="playerName" type="text" className="form-control" />
              <ErrorMessage
                component="div"
                name="playerName"
                className="text-danger"
              />
            </div>

            {/* Age */}
            <div className="mb-3">
              <label className="form-label">Age</label>
              <Field name="age" type="number" className="form-control" />
              <ErrorMessage
                component="div"
                name="age"
                className="text-danger"
              />
            </div>

            {/* Position */}
            <div className="mb-3">
              <label className="form-label">Position</label>
              <Field as="select" name="position" className="form-select">
                <option value="">Select Position</option>
                <option value="Forward">Forward</option>
                <option value="Defense">Defense</option>
                <option value="Goalkeeper">Goalkeeper</option>
              </Field>
              <ErrorMessage
                component="div"
                name="position"
                className="text-danger"
              />
            </div>

            {/* Team Name */}
            <div className="mb-3">
              <label className="form-label">Team Name</label>
              <Field name="teamName" type="text" className="form-control" />
              <ErrorMessage
                component="div"
                name="teamName"
                className="text-danger"
              />
            </div>

            {/* Captain */}
            <div className="form-check mb-3">
              <Field
                type="checkbox"
                name="captain"
                className="form-check-input"
              />
              <label className="form-check-label">Captain</label>
            </div>

            {/* Skills */}
            <div className="mb-3">
              <label className="form-label">Skills</label>
              <FieldArray name="skills">
                {({ push, remove }) => (
                  <div>
                    {values.skills.map((_, index) => (
                      <div key={index} className="d-flex mb-2">
                        <Field
                          name={`skills[${index}]`}
                          type="text"
                          className="form-control me-2"
                        />
                        <button
                          type="button"
                          className="btn btn-danger"
                          onClick={() => remove(index)}
                        >
                          Remove
                        </button>
                      </div>
                    ))}
                    <button
                      type="button"
                      className="btn btn-secondary"
                      onClick={() => push("")}
                    >
                      Add Skill
                    </button>
                  </div>
                )}
              </FieldArray>
              <ErrorMessage
                component="div"
                name="skills"
                className="text-danger"
              />
            </div>

            {/* Past Teams */}
            <div className="mb-3">
              <label className="form-label">Past Teams</label>
              <FieldArray name="pastTeams">
                {({ push, remove }) => (
                  <div>
                    {values.pastTeams.map((_, index) => (
                      <div key={index} className="mb-2">
                        <Field
                          name={`pastTeams[${index}].clubName`}
                          placeholder="Club Name"
                          className="form-control mb-1"
                        />
                        <ErrorMessage
                          component="div"
                          name={`pastTeams[${index}].clubName`}
                          className="text-danger"
                        />
                        <Field
                          name={`pastTeams[${index}].years`}
                          placeholder="Years"
                          type="number"
                          className="form-control mb-1"
                        />
                        <ErrorMessage
                          component="div"
                          name={`pastTeams[${index}].years`}
                          className="text-danger"
                        />
                        <button
                          type="button"
                          className="btn btn-danger mb-2"
                          onClick={() => remove(index)}
                        >
                          Remove Team
                        </button>
                      </div>
                    ))}
                    <button
                      type="button"
                      className="btn btn-secondary"
                      onClick={() => push({ clubName: "", years: "" })}
                    >
                      Add Past Team
                    </button>
                  </div>
                )}
              </FieldArray>
            </div>

            {/* Submit */}
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </Form>
        )}
      </Formik>
    </div>
  );
};

export default HockeyTournamentForm;
